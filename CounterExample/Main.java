package CounterExample;

import java.util.Arrays;

public class Main {
  private static final String DESIGN_PATTERNS_CODE = "INF 335";
  private static final String TURKISH_CODE = "MDE 342";
  private static final String INDUSTRIAL_PRACTICE_CODE = "CSS 381";
  private static final String NLP_CODE = "INF 376";
  private static final String SOFTWARE_ENGINEERING_CODE = "CSS 342";
  private static final String PHILOSOPHY_CODE = "MDE 172";
  private static final String CULTURAL_STUDIES_CODE = "MDE 153";

  public static void main(String[] args) {
    SingleCounter counter = SingleCounter.getInstance();
    counter.increment();
    counter.increment();
    counter.increment();
    counter.decrement(8);
    System.out.println(counter.getValue());

    SDU sdu = SDU.getInstance();
    sdu.createCourse("Design Patterns", DESIGN_PATTERNS_CODE);
    sdu.createCourse("Turkish Language", TURKISH_CODE);
    sdu.createCourse("Industrial Practice", INDUSTRIAL_PRACTICE_CODE);
    sdu.createCourse("Natural Language Processing", NLP_CODE);
    sdu.createCourse("Software Engineering", SOFTWARE_ENGINEERING_CODE);
    sdu.createCourse("Philosophy", PHILOSOPHY_CODE);
    sdu.createCourse("Cultural Studies", CULTURAL_STUDIES_CODE);

    SDU.Student me = sdu.register("Rassul", "Bessimbekov");
    SDU.Student Abat = sdu.register("Abat", "Kassymov");

    me.enroll(sdu.getCourse(DESIGN_PATTERNS_CODE));
    me.enroll(sdu.getCourse(TURKISH_CODE));
    me.enroll(sdu.getCourse(NLP_CODE));
    me.enroll(sdu.getCourse(PHILOSOPHY_CODE));

    Abat.enroll(sdu.getCourse(TURKISH_CODE));
    Abat.enroll(sdu.getCourse(CULTURAL_STUDIES_CODE));
    Abat.enroll(sdu.getCourse(INDUSTRIAL_PRACTICE_CODE));

    System.out.println(me);
    System.out.println();
    System.out.println(Abat);
    System.out.println();
    System.out.println();

    Abat.unenroll(sdu.getCourse(TURKISH_CODE));
    System.out.println("Abat after unenrolling from turkish:");
    System.out.println(Abat);

    System.out.println();
    System.out.println("SDU courses total:");
    sdu.printCourses();
    System.out.println();
    System.out.println("SDU students total:");
    System.out.println();
    sdu.printStudents();
  }
}
