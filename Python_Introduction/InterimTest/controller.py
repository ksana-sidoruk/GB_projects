from model import Notes
import text
import view

def search_note(pb):
    word = view.input_request(text.input_search_word)
    result = pb.find_note(word)
    view.show_note(pb, text.not_find(word), result)
    if result:
        return True
    
def start():
    pb = Notes('notes.json')
    while True:
        choice = view.main_menu()
        match choice:
            case 1:
                pb.open_file()
                view.print_message(text.load_successful) 
            case 2:
                pb.save_file()
                view.print_message(text.save_successful) 
            case 3:
                view.show_note(pb, text.empty_notes_error)
            case 4:
                new_note = view.input_note(text.input_note)
                pb.add_note(new_note)
                view.print_message(text.note_action(new_note[0], text.operation[0]))
            case 5:
                search_note(pb)
            case 6:
                if search_note(pb):
                    c_id = int(view.input_request(text.input_edit_note_id))
                    new_note = view.input_note(text.input_edit_note)
                    title = pb.edit_note(c_id, new_note)
                    view.print_message(text.note_action(title, text.operation[1]))
            case 7:
                if search_note(pb):
                    c_id = int(view.input_request(text.input_del_note_id))
                    title = pb.delete_note(c_id)
                    view.print_message(text.note_action(title, text.operation[2]))
            case 8:                  
                view.print_message(text.exit_program)
                break
