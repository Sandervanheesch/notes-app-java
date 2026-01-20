public class Note {

    int noteId;
    String title;
    String text;

    //Constructor
    Note(int noteId, String title, String text) {
        this.noteId = noteId;
        this.title = title;
        this.text = text;
    }


    //Getters
    int getNoteId() {
        return this.noteId;
    }

    String getTitle() {
        return this.title;
    }

    String getText() {
        return this.text;
    }


    //Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

}
