package Endterm;

import java.util.*;

class MapCourse {
    String name;
    public MapCourse(String name) {
        this.name = name;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name); //Kayipov Yerasyl
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MapCourse course = (MapCourse) obj;
        return Objects.equals(name, course.name);
    }
    @Override
    public String toString() {
        return name;
    }
}

class ConflictGraph {
    private final Map<MapCourse, List<MapCourse>> conflictMap;

    public ConflictGraph() {
        this.conflictMap = new HashMap<>();
    }
    public void addCourse(MapCourse course) {
        conflictMap.putIfAbsent(course, new ArrayList<>());
    }//Add a course to the graph, if it doesn't exist

    public void addConflict(MapCourse c1, MapCourse c2) {
        addCourse(c1);
        addCourse(c2); //Conflict model
        conflictMap.get(c1).add(c2);
        conflictMap.get(c2).add(c1);
    }       //Kayipov Yerasyl
    public void printGraph() {
        for (Map.Entry<MapCourse, List<MapCourse>> entry : conflictMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}

public class task3 {
    public static void main(String[] args) {
        MapCourse Theory023 = new MapCourse("Theory 023");
        MapCourse Math534 = new MapCourse("Math 534");
        MapCourse Java786 = new MapCourse("Java 786");
        ConflictGraph graph = new ConflictGraph();

        //Test for conflict
        graph.addConflict(Theory023, Math534);     //Instructor conflict
        graph.addConflict(Theory023, Java786);   //Classroom conflict


        System.out.println("Conflict Graph:");
        graph.printGraph();

        System.out.println("Line");
        // Create courses
        Course Theory024 = new Course("Theory024");
        Course Math535 = new Course("Math535");
        Course Java787 = new Course("Java787");
        Course DTB099 = new Course("DTB099");

        //Initialize the conflict graph
        BFSConflictGraph newGraph = new BFSConflictGraph();
        newGraph.addBFSConflicts(Theory024, Math535);  //Conflict 1
        newGraph.addBFSConflicts(Math535, Java787);  //Conflict 2
        newGraph.addBFSConflicts(Java787, DTB099);  //Conflict 3

        //Graph traversal
        BFSGraphTraversal traversal = new BFSGraphTraversal();

        //Perform BFS
        System.out.println("BFS Traversal Starting from CS101:");
        traversal.bfs(newGraph, Theory024 );

        //Perform DFS
        System.out.println("\nDFS Traversal Starting from CS101:");
        traversal.dfs(newGraph, Theory024);
    }
}

class Course {
    String name;

    public Course(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Course course = (Course) obj;
        return Objects.equals(name, course.name);
    } //Kayipov Yerasyl
    @Override
    public String toString() {
        return name;
    }
}

class BFSConflictGraph {
    Map<Course, List<Course>> conflictMap = new HashMap<>();

    public void addBFSCourse(Course course) {
        conflictMap.putIfAbsent(course, new ArrayList<>());
    }//Add a course to the graph if it doesn't exist

    public void addBFSConflicts(Course c1, Course c2) {
        addBFSCourse(c1);
        addBFSCourse(c2);

        conflictMap.get(c1).add(c2);
        conflictMap.get(c2).add(c1);
    }//Add a conflict (edge) between two courses


    public List<Course> getBFSConflicts(Course course) {
        return conflictMap.getOrDefault(course, Collections.emptyList());
    }//Get all courses conflicting with a given course
}

class BFSGraphTraversal {
    public void bfs(BFSConflictGraph graph, Course startCourse) {
        Set<Course> visited = new HashSet<>();
        Queue<Course> queue = new LinkedList<>();

        queue.add(startCourse);
        visited.add(startCourse); //Kayipov Yerasyl

        System.out.println("BFS Traversal:");
        while (!queue.isEmpty()) {
            Course current = queue.poll();
            System.out.println("Visited: " + current);

            for (Course neighbor : graph.getBFSConflicts(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    // DFS for dependency resolution
    public void dfs(BFSConflictGraph graph, Course startCourse) {
        Set<Course> visited = new HashSet<>();
        System.out.println("DFS Traversal:");
        dfsHelper(graph, startCourse, visited);
    }

    private void dfsHelper(BFSConflictGraph graph, Course course, Set<Course> visited) {
        if (visited.contains(course)) {
            return; //Kayipov Yerasyl
        }

        visited.add(course);
        System.out.println("Visited: " + course);

        for (Course neighbor : graph.getBFSConflicts(course)) {
            dfsHelper(graph, neighbor, visited);
        }
    }
}







