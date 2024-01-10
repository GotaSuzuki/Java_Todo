import java.util.Scanner;

public class Main {
  enum Choice {
    Add, Remove, Display, SortDisplay, Exit
  }

  public static void main(String[] args) {
    TodoList TodoList = new TodoList();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("------------------------------");
      System.out.println("操作を選択してください:");
      System.out.println("1. タスクを追加");
      System.out.println("2. タスクを削除");
      System.out.println("3. タスクを表示");
      System.out.println("4. 優先度順にタスクを表示");
      System.out.println("5. 終了");
      System.out.print(">>>");

      // 選択肢を受け取っている
      int choiceNum = scanner.nextInt();
      Choice choice = Choice.values()[choiceNum - 1];
      scanner.nextLine();

      switch (choice) {
        case Add:
          System.out.print("新しいタスクを入力して下さい：");
          String task = scanner.nextLine();
          System.out.print("優先度を入力して下さい：");
          int priority = scanner.nextInt();
          TodoList.addItem(task, priority);
          break;
        case Remove:
          System.out.print("削除するUUID番号を入力して下さい:");
          String index = scanner.nextLine();
          TodoList.removeItem(index);
          break;
        case Display:
          TodoList.displayItem();
          break;
        case SortDisplay:
          TodoList.sortByPriority();
          break;
        case Exit:
          System.out.println("アプリケーションを終了します");
          scanner.close();
          System.exit(0);
          break;
        default:
          System.out.println("無効な選択です。もう一度試して下さい");
      }
    }
  }
}
