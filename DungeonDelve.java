import java.util.Scanner;

public class DungeonDelve {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer count = 0;
		BinaryTree<Character> bt = new BinaryTree<>();

		String input = sc.nextLine();

		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if(Character.isDigit(c)) break;
			bt.insert(Character.toUpperCase(c));
		}

		String clue = sc.nextLine();

		if(bt.return_size() < clue.length()) {
			System.out.println("NOT SOLVABLE");
			System.exit(0);
		}

		for(int i = 0; i < clue.length(); i++) {
			char c = clue.charAt(i);
			if(Character.isDigit(c)) break;
			if(count == clue.length()-1 && bt.search_tree(Character.toUpperCase(c))) {
				System.out.println("Exit the dungeon!");
				break;
			}
			if(!bt.search_tree(Character.toUpperCase(c))) {
				System.out.println("NOT SOLVABLE");
				break;
			}
			count++;
		}
	}
}
