import text
from model import Note, Notes

def main_menu():
    for i, item in enumerate(text.menu):
        if i == 0:
            print(item)
        else:
            print(f'\t{i}. {item}')

    while True:
        choice = input(text.input_menu)
        if choice.isdigit() and 0 < int(choice) < len(text.menu):
            return int(choice)
        else:
            print(text.input_menu_error)

def print_message(msg):
    print('\n' + '=' * len(msg))
    print(msg)
    print('=' * len(msg) + '\n' )

def show_note(notes: Notes, msg: str, print_items: dict[int, Note] = None):

    if print_items is None:
        print_items = notes.notes

    if print_items:        
        print('\n' + '*' * (notes.max_len("title") + notes.max_len("body") + 5))
        for i, note in print_items.items():
            print(f'{i:>3}. {note.title:<{notes.max_len("title") + 5}}'
                  f'{note.body:<{notes.max_len("body") + 5}}') 
        print('*' * (notes.max_len("title") + notes.max_len("body") + 5) + '\n' )
    else:
        print_message(msg)

def input_note(msg: str) -> list[str]:
    contact = []
    for input_text in msg:
        contact.append(input(input_text))
    return contact

def input_request(msg:str) -> str:
    return input(msg)



