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
                choiceIsCreateNote(inputMain, mainNotesList);                
            }

            else if (choiceMain == 2) {
                mainNotesList.showNotesList();

                System.out.println("\nDo you want to select a specific note (type 'y') or go back (type anything else)");
                
                String yOrNot = inputMain.nextLine();
                if (yOrNot.equals("y")) {
                    System.out.println("\nType which note you want to select by typing the number of the note shown in the list:");
                    int noteNumberSelected = inputMain.nextInt();
                    inputMain.nextLine();

                    Note specificNoteSelected = mainNotesList.getNote(noteNumberSelected-1);

                    System.out.println("You have selected number " + noteNumberSelected + " Which is note titled " + specificNoteSelected.getTitle());

                    System.out.println("\n************************");
                    System.out.println("Press the corresponding number for what action you want to perform:");
                    System.out.println("1. Read note");
                    System.out.println("2. Delete note");
                    System.out.println("3. Update note");
                    System.out.println("0. Go back");
                    System.out.println("************************");

                    int specificNoteChoice = inputMain.nextInt();
                    inputMain.nextLine();

                    if (specificNoteChoice == 1) {
                        System.out.println("\nNow showing your selected note");
                        System.out.println("\n" + specificNoteSelected.getTitle());
                        System.out.println("\n" + specificNoteSelected.getText());
                    }

                }
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

    public static void choiceIsCreateNote(Scanner scanner, NotesList mainNotesList) {
        System.out.print("Write your title: ");
                String titleInput = scanner.nextLine();
                

                System.out.println("Write your text: ");
                String textInput = scanner.nextLine();
                
                
                int highestNoteId = 0;

                for (Note note : mainNotesList.getNotesList()) {
                    if (note.getNoteId() > highestNoteId) {
                        highestNoteId = note.getNoteId();
                    }
                }

        mainNotesList.addNote(new Note(highestNoteId, titleInput, textInput));
    }

}
