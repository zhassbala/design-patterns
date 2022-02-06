package CounterExample;

public class SingleCounter{
  private static SingleCounter instance;
  private int counter;

  private SingleCounter(){
    this.counter = 0;
  }

  public static SingleCounter getInstance(){
    if (instance == null){
      instance = new SingleCounter();
    }
    return instance;
  }
  void log(){
    System.out.println("Now the value is " + this.counter + "!");
  }
  void log(String payload){
    System.out.println(payload + ". Now the value is " + this.counter + ".");
  }

  void increment(){
    this.counter++;
    this.log("The counter has been incremented");
  }
  void decrement(){
    this.counter--;
    this.log("The counter has been decremented");
  }
  void increment(int val){
    this.counter += val;
    this.log("The counter has been incremented for " + val);
  }
  void decrement(int val){
    this.counter -= val;
    this.log("The counter has been decremented for " + val);
  }
  int getValue(){
    return this.counter;
  }
}