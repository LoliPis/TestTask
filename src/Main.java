public class Main {
  public static void main(String[] args) {
    ActionCounter actionCounter = new ActionCounter();
    actionCounter.call(1);
    actionCounter.call(2);
    actionCounter.call(2);
    System.out.println(actionCounter.getActions(4));
    actionCounter.call(300);
    System.out.println(actionCounter.getActions(300));
    System.out.println(actionCounter.getActions(301));
    actionCounter.call(301);
    System.out.println(actionCounter.getActions(599));
    actionCounter.call(400);
    System.out.println(actionCounter.getActions(600));
    System.out.println(actionCounter.getActions(1));
  }
}
