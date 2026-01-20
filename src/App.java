import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner inputMain = new Scanner(System.in);
        boolean running = true;
        NotesList mainNotesList = new NotesList();

        while (running) {
            int choiceMain = startMenu(inputMain);
            running = optionsMethod(inputMain, choiceMain, mainNotesList, running);
        }
        inputMain.close();
    }


        private static int startMenu(Scanner scanner) {
        System.out.println("\n************************");
        System.out.println("Press the corresponding number for what action you want to perform:");
        System.out.println("1. Create new note");
        System.out.println("2. Show list of existing notes");
        System.out.println("0. Exit");
        System.out.println("************************");
        
        System.out.print("Your choice is: ");
        int choiceMain = scanner.nextInt();
        scanner.nextLine();

        return choiceMain;
    }

    private static void noteMenu() {
        System.out.println("\n************************");
        System.out.println("Press the corresponding number for what action you want to perform:");
        System.out.println("1. Read note");
        System.out.println("2. Delete note");
        System.out.println("3. Update note");
        System.out.println("0. Go back");
        System.out.println("************************");
    }

    public static boolean optionsMethod(Scanner scanner, int choiceMain, NotesList mainNotesList, boolean running) {
        if (choiceMain == 1) {
            choiceIsCreateNote(scanner, mainNotesList);                
        }

        else if (choiceMain == 2) {
            choiceIsShowNotesList(scanner, mainNotesList);
        }

        else if (choiceMain == 0) {
            System.out.println("Exiting notes app...");
            running = false;
        }

        else {
            System.out.println("Invalid choice");
        }

        return running;
    }


    public static void choiceIsCreateNote(Scanner scanner, NotesList mainNotesList) {
        System.out.print("Write your title: ");
            String titleInput = scanner.nextLine();
            

            System.out.print("Write your text: ");
            String textInput = scanner.nextLine();
            
            
            int highestNoteId = 0;

            for (Note note : mainNotesList.getNotesList()) {
                if (note.getNoteId() > highestNoteId) {
                    highestNoteId = note.getNoteId();
                }
            }

        mainNotesList.addNote(new Note(highestNoteId, titleInput, textInput));
    }


    private static void choiceIsShowNotesList(Scanner scanner, NotesList mainNotesList) {
        mainNotesList.showNotesList();

        System.out.println("\nDo you want to select a specific note (type 'y') or go back (type anything else)");
        
        String yOrNot = scanner.nextLine();
        if (yOrNot.equals("y")) {
            System.out.println("\nType which note you want to select by typing the number of the note shown in the list:");
            int noteNumberSelected = scanner.nextInt();
            scanner.nextLine();

            Note specificNoteSelected = mainNotesList.getNote(noteNumberSelected - 1);

            System.out.println("You have selected note number " + noteNumberSelected + " Which is note titled " + specificNoteSelected.getTitle());

            noteMenu();

            int specificNoteChoice = scanner.nextInt();
            scanner.nextLine();

            if (specificNoteChoice == 1) {
                System.out.println("\nNow showing note number " + noteNumberSelected);
                System.out.println("\n" + specificNoteSelected.getTitle());
                System.out.println("\n" + specificNoteSelected.getText());
            }

            else if (specificNoteChoice == 2) {
                System.out.println("\nNow deleting note number " + noteNumberSelected);
                mainNotesList.removeNote(noteNumberSelected - 1);
            }

            else if (specificNoteChoice == 3) {
                System.out.println("\nNow updating note number " + noteNumberSelected);
                System.out.println("Write your new title: ");
                String newTitle = scanner.nextLine();
                System.out.println("Write your new text: ");
                String newText = scanner.nextLine();

                specificNoteSelected.setTitle(newTitle);
                specificNoteSelected.setText(newText);
            }
            
        }
    }
}
