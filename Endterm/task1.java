package Endterm;

import java.util.PriorityQueue;

class CourseNode {
    int courseId;
    String name;
    int credits;
    String department;
    CourseNode left, right; //Kayipov Yerasyl
    public CourseNode(int courseId, String name, int credits, String department) {
        this.courseId = courseId;
        this.name = name;
        this.credits = credits;
        this.department = department;
        this.left = this.right = null;
    }
}
class CourseBST {
    private CourseNode root;
    public void insert(int courseId, String name, int credits, String department) {
        root = insertRec(root, new CourseNode(courseId, name, credits, department));
    } //We are inserting data with this characters
    private CourseNode insertRec(CourseNode root, CourseNode newNode) {
        if (root == null) return newNode;
        if (newNode.courseId < root.courseId) {
            root.left = insertRec(root.left, newNode);
        } else {
            root.right = insertRec(root.right, newNode);
        }
        return root;
    }//Rooms is inserted in hierarchical order due to credit

    public CourseNode search(int courseId) {
        return searchRec(root, courseId);
    }
    private CourseNode searchRec(CourseNode root, int courseId) {
        if (root == null || root.courseId == courseId) return root;
        if (courseId < root.courseId) return searchRec(root.left, courseId);
        return searchRec(root.right, courseId);
    }//Searching for element by name(root) or courseId with recursive
    public void delete(int courseId) {
        root = deleteRec(root, courseId);
    }
    private CourseNode deleteRec(CourseNode root, int courseId) {
        if (root == null) return root;
        if (courseId < root.courseId) {
            root.left = deleteRec(root.left, courseId);
        } else if (courseId > root.courseId) {      //Kayipov Yerasyl
            root.right = deleteRec(root.right, courseId);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            CourseNode minNode = getMin(root.right);
            root.courseId = minNode.courseId;
            root.name = minNode.name;
            root.credits = minNode.credits;
            root.department = minNode.department;
            root.right = deleteRec(root.right, minNode.courseId);
        }// Searching and deleting the element
        return root;
    }
    private CourseNode getMin(CourseNode root) {
        while (root.left != null) root = root.left;
        return root;
    }
}



class Classroom {
    int size;
    String roomId;
    public Classroom(int size, String roomId) {
        this.size = size;
        this.roomId = roomId;
    }
}

class ClassroomAllocator {
    private PriorityQueue<Classroom> minHeap;

    public ClassroomAllocator() {minHeap = new PriorityQueue<>((a, b) -> a.size - b.size);}
    public void addClassroom(int size, String roomId) {minHeap.offer(new Classroom(size, roomId));}
    public Classroom allocateRoom(int classSize) {
        for (Classroom room : minHeap) {//Kayipov Yerasyl
            if (room.size >= classSize) {
                minHeap.remove(room);
                return room;
            }
        }
        return null; //if room small for it
    }
    public void releaseRoom(int size, String roomId) {minHeap.offer(new Classroom(size, roomId));}
}

// **3. Priority Queue for Instructor Scheduling**
class Instructor {
    String name;
    String[] subjects;
    int[] availability; //time slots
    public Instructor(String name, String[] subjects, int[] availability) {
        this.name = name;
        this.subjects = subjects;
        this.availability = availability;   }}
class CourseAssignment {
    int priority;
    Instructor instructor;
    String course; //Kayipov Yerasyl
    public CourseAssignment(int priority, Instructor instructor, String course) {
        this.priority = priority;
        this.instructor = instructor;
        this.course = course;   }}
class InstructorScheduler {
    private PriorityQueue<CourseAssignment> priorityQueue;
    public InstructorScheduler() {
        priorityQueue = new PriorityQueue<>((a, b) -> a.priority - b.priority);}
    public void addTask(int priority, Instructor instructor, String course) {
        priorityQueue.offer(new CourseAssignment(priority, instructor, course));}
    public CourseAssignment assignTask() {
        return priorityQueue.poll();}
}


public class task1 {
    public static void main(String[] args) {
        // Initialize BST for courses
        CourseBST courseBST = new CourseBST();
        courseBST.insert(101, "Math 101", 3, "Mathematics");
        courseBST.insert(202, "CS 202", 4, "Computer Science");
        courseBST.insert(303, "Physics 303", 3, "Physics");
        courseBST.delete(101);
        CourseNode course = courseBST.search(101);
        System.out.println("Found course: " + (course != null ? course.name : "None"));




        ClassroomAllocator allocator = new ClassroomAllocator();
        allocator.addClassroom(30, "Room A");
        allocator.addClassroom(50, "Room B");
        Classroom assignedRoom = allocator.allocateRoom(35);
        System.out.println("Assigned Room: " + (assignedRoom != null ? assignedRoom.roomId : "None"));
        allocator.releaseRoom(30, "Room A");

        System.out.println("End");
        // Initialize Instructor Scheduler
        InstructorScheduler scheduler = new InstructorScheduler();
        Instructor Adam1 = new Instructor("Adam1", new String[]{"Math", "Physics"}, new int[]{1, 2});
        Instructor Adam2 = new Instructor("Adam2", new String[]{"CS", "Math"}, new int[]{1, 3});
        scheduler.addTask(3, Adam1, "Math 342");
        scheduler.addTask(1, Adam2, "CS 561");

        CourseAssignment task = scheduler.assignTask();
        System.out.println("Assigned Task: " + task.course + " to " + task.instructor.name);
    }
}
