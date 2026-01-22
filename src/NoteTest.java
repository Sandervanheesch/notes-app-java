import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoteTest {

    private Note note;

    @BeforeEach
    void setup() {
        note = new Note(1, "TEST", "test");
    }

    @Test
    void getNoteId() {
        //Arrange
        int expectedNoteId = 1;
        int actualNoteId;

        //Act
        actualNoteId = note.getNoteId();

        //Assert
        assertEquals(expectedNoteId, actualNoteId);

    }

    @Test
    void getTitle() {
    }

    @Test
    void getText() {
    }
}