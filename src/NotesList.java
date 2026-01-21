import java.util.ArrayList;
import java.util.List;

public class NotesList {
    
    private List<Note> notes = new ArrayList<>();

    public void addNote(Note note) {
        notes.add(note);
    }

    public void removeNote(int index) {
        notes.remove(index);
    }

    public List<Note> getNotesList() {
        return notes;
    }

    public Note getNote(int index) {
        return notes.get(index);
    }

    public void showNotesList() {
        List<Note> notesListToShow = getNotesList();

        System.out.println("\nList of your notes titles");
        for (int i=0; i < notesListToShow.size(); i++) {
            
            System.out.println(i+1 + ". " + notesListToShow.get(i).getTitle());
        }
    }
}


