import json

class Note:
    def __init__(self, title: str, body: str):
        self.title = title
        self.body = body

    def to_dict(self):
        return {
            'title': self.title.encode('utf-8').decode('latin1'),
            'body': self.body.encode('utf-8').decode('latin1')
        }

    @classmethod
    def from_dict(cls, note_dict):
        return cls(note_dict['title'].encode('latin1').decode('utf-8'),
                   note_dict['body'].encode('latin1').decode('utf-8'))

    def __str__(self):
        return self.title


class Notes:
    def __init__ (self, path): 
        self.path = path 
        self.notes: dict[int, Note] = {}

    def open_file(self):
        with open(self.path) as json_file:
            data = json.load(json_file)
            notes_list = [Note.from_dict(note_data) for note_data in data]
            index = 1
            for note in notes_list:
                self.notes[index] = note
                index += 1
     
    def save_file(self):
        data = [note.to_dict() for note in self.notes.values()]
        with open(self.path, 'w') as json_file:
            json.dump(data, json_file, indent=4)

    def add_note(self, new_note: list[str]):
        if not self.notes:
             c_id = 1 
        else:
            c_id = max(self.notes) + 1
        self.notes[c_id] = Note(*new_note)

    def find_note(self, word: str) -> dict[int, Note]:
        result = {}
        for c_id, note in self.notes.items():
            if word.lower() in note.title.lower():
                result[c_id] = note
                continue
            if word.lower() in note.body.lower():
                result[c_id] = note
                continue    
        return result

    def edit_note(self, c_id: int, new_note: list[str]):
        current_note = self.notes.get(c_id)
        if new_note[0]:
            current_note.title = new_note[0]
        if new_note[1]:
            current_note.body = new_note[1]
        return current_note

    def delete_note(self, c_id: int) -> str:
        return self.notes.pop(c_id).title

    def max_len(self, option: str):
        result = []
        for note in self.notes.values():
            if option == 'title':
                item = note.title
            elif option == 'body':
                item = note.body
            result.append(item)
        return len(max(result, key = len))