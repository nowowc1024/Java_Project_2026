import java.util.ArrayList;
import java.util.List;

public class Project {

    private String name;
    private int requiredWork;
    private int progress;
    private int turns;

    // 4B: accepts any Workable (Employee, AutomatedTool, FreelancerBot, etc.)
    private List<Workable> team;

    // 4A: lifecycle state
    private ProjectStatus status;

    // ------------------------------------------------------------
    // Constructor
    // ------------------------------------------------------------
    public Project(String name, int requiredWork) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Project name cannot be null or blank.");

        if (requiredWork <= 0)
            throw new IllegalArgumentException("Required work must be greater than 0.");

        this.name = name;
        this.requiredWork = requiredWork;
        this.progress = 0;
        this.turns = 0;
        this.team = new ArrayList<>();
        this.status = ProjectStatus.PLANNED;   // every project begins as PLANNED
    }

    // ------------------------------------------------------------
    // Lifecycle methods (Lesson 4A)
    // ------------------------------------------------------------

    // Must call start() before work can proceed
    public void start() {
        if (status == ProjectStatus.PLANNED) {
            status = ProjectStatus.IN_PROGRESS;
            System.out.println("[" + name + "] Status changed to: " + status);
        }
    }

    // Exercise 4A-1: put on hold from IN_PROGRESS
    public void putOnHold() {
        if (status == ProjectStatus.IN_PROGRESS) {
            status = ProjectStatus.ON_HOLD;
            System.out.println("[" + name + "] Status changed to: " + status);
        }
    }

    // Exercise 4A-2: resume from ON_HOLD
    public void resume() {
        if (status == ProjectStatus.ON_HOLD) {
            status = ProjectStatus.IN_PROGRESS;
            System.out.println("[" + name + "] Status changed to: " + status);
        }
    }

    // Cancel at any point before FINISHED
    public void cancel() {
        if (status != ProjectStatus.FINISHED) {
            status = ProjectStatus.CANCELLED;
            System.out.println("[" + name + "] Status changed to: " + status);
        }
    }

    // ------------------------------------------------------------
    // Work logic
    // ------------------------------------------------------------
    public void workOneTurn() {

        // Work is blocked unless IN_PROGRESS
        if (status != ProjectStatus.IN_PROGRESS) {
            System.out.println("[" + name + "] Cannot work — status: " + status);
            return;
        }

        // Team contributes work
        for (Workable w : team) {
            progress += w.work();
        }

        turns++;

        // Check for completion
        if (progress >= requiredWork) {
            progress = requiredWork;
            status = ProjectStatus.FINISHED;
            System.out.println("[" + name + "] Status changed to: " + status);
        }
    }

    // ------------------------------------------------------------
    // Team management
    // ------------------------------------------------------------
    public void addWorker(Workable w) {
        if (w == null)
            throw new IllegalArgumentException("Worker cannot be null.");
        team.add(w);
    }

    // Backward compatibility for older code
    public void addEmployee(Employee e) {
        addWorker(e);
    }

    // ------------------------------------------------------------
    // Getters
    // ------------------------------------------------------------
    public boolean isFinished() {
        return status == ProjectStatus.FINISHED;
    }

    public int getTurns() {
        return turns;
    }

    public String getName() {
        return name;
    }

    public int getProgress() {
        return progress;
    }

    public int getRequiredWork() {
        return requiredWork;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    // ------------------------------------------------------------
    // Debug / printing
    // ------------------------------------------------------------
    public void printStatus() {
        System.out.println("Project: " + name);
        System.out.println("Status: " + status);
        System.out.println("Progress: " + progress + " / " + requiredWork);
        System.out.println("Turns so far: " + turns);
        System.out.println("Finished: " + isFinished());
        System.out.println("-----------------------------");
    }
}