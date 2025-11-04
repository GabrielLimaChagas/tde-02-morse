public class MorseTree {
    private Node root;

    public MorseTree() {
        this.root = new Node(' ');
        buildTree();
    }

    public void insert(char character, String morseCode) {
        Node current = this.root;
        for (char symbol : morseCode.toCharArray()) {
            if (symbol == '.') {
                if (current.left == null) {
                    current.left = new Node(' ');
                }
                current = current.left;
            } else if (symbol == '-') {
                if (current.right == null) {
                    current.right = new Node(' ');
                }
                current = current.right;
            }
        }
        current.character = character;
    }

    private char decodeSingleChar(String morseCode) {
        Node current = this.root;
        for (char symbol : morseCode.toCharArray()) {
            if (symbol == '.') {
                current = current.left;
            } else if (symbol == '-') {
                current = current.right;
            }

            if (current == null) {
                return '?';
            }
        }
        return current.character;
    }

    public String decodeWord(String morseSequence) {
        StringBuilder decodedWord = new StringBuilder();
        String[] morseChars = morseSequence.split(" ");

        for (String morseChar : morseChars) {
            decodedWord.append(decodeSingleChar(morseChar));
        }

        return decodedWord.toString();
    }

    public void printTree() {
        System.out
                .println("\n--- Visualização da Árvore Binária de Busca Morse ---");
        printTree(root, "", false);
        System.out.println("--------------------------------------------------------------------------------------");
    }

    private void printTree(Node node, String prefix, boolean isLeft) {
        if (node == null) {
            return;
        }

        printTree(node.right, prefix + (isLeft ? "|    " : "     "), false);

        String connection = isLeft ? "└─ . " : "┌─ - ";
        if (node == root) {
            connection = "Root: ";
        }

        if (node.character != ' ') {
            System.out.println(prefix + connection + "[" + node.character + "]");
        } else {
            System.out.println(prefix + connection + "[ ]");
        }

        printTree(node.left, prefix + (isLeft ? "     " : "|    "), true);
    }

    private void buildTree() {
        insert('A', ".-");
        insert('B', "-...");
        insert('C', "-.-.");
        insert('D', "-..");
        insert('E', ".");
        insert('F', "..-.");
        insert('G', "--.");
        insert('H', "....");
        insert('I', "..");
        insert('J', ".---");
        insert('K', "-.-");
        insert('L', ".-..");
        insert('M', "--");
        insert('N', "-.");
        insert('O', "---");
        insert('P', ".--.");
        insert('Q', "--.-");
        insert('R', ".-.");
        insert('S', "...");
        insert('T', "-");
        insert('U', "..-");
        insert('V', "...-");
        insert('W', ".--");
        insert('X', "-..-");
        insert('Y', "-.--");
        insert('Z', "--..");
        insert('1', ".----");
        insert('2', "..---");
        insert('3', "...--");
        insert('4', "....-");
        insert('5', ".....");
        insert('6', "-....");
        insert('7', "--...");
        insert('8', "---..");
        insert('9', "----.");
        insert('0', "-----");
    }
}