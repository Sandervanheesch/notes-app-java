import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner inputMain = new Scanner(System.in);
        boolean running = true;
        NotesList mainNotesList = new NotesList();

        while (running) {

            System.out.println("\n************************");
            System.out.println("Press the corresponding number for what action you want to perform:");
            System.out.println("1. Create new note");
            System.out.println("2. Show list of existing notes");
            System.out.println("0. Exit");
            System.out.println("************************");

            System.out.print("Your choice is: ");
            int choiceMain = inputMain.nextInt();
            inputMain.nextLine();

            if (choiceMain == 1) {
                
                System.out.print("Write your title: ");
                String titleInput = inputMain.nextLine();
                

                System.out.println("Write your text: ");
                String textInput = inputMain.nextLine();
                
                
                int highestNoteId = 0;

                for (Note note : mainNotesList.getNotesList()) {
                    if (note.getNoteId() > highestNoteId) {
                        highestNoteId = note.getNoteId();
                    }
                }

                mainNotesList.addNote(new Note(highestNoteId, titleInput, textInput));
            }

            else if (choiceMain == 2) {
                mainNotesList.showNotesList();

                System.out.println("Do you want to select a specific note (type 'y') or go back (type anything else)");
                
                String yOrNot = inputMain.nextLine();
                if (yOrNot.equals('y')) {
                    System.out.println("Type which note you want to select by typing the number of the note:");
                    int noteNumberSelected = inputMain.nextInt();
                    inputMain.nextLine();

                    System.out.println("You have selected number " + noteNumberSelected + " Which is note titled " + mainNotesList.getNote(noteNumberSelected-1).getTitle());

                }
                int indexSelectedNote = inputMain.nextInt();
            }

            else if (choiceMain == 0) {
                System.out.println("Exiting notes app");
                running = false;
            }

            else {
                System.out.println("Invalid choice");
            }

        }
        
        inputMain.close();

        
    }
}
