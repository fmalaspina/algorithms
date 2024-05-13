package com.app;

import java.util.*;

public class BreathFirst {

    class Person {
        public String name;

        public boolean isMangoSeller = false;
        public Person(String name, boolean isMangoSeller) {
            this.name = name;
            this.isMangoSeller = isMangoSeller;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", isMangoSeller=" + isMangoSeller +
                    '}';
        }
    }
    class Graph {
        public Map<Person, List<Person>> friends = new HashMap<>();
        public void addVertex(String name, boolean isMangoSeller) {
            friends.putIfAbsent(new Person(name, isMangoSeller), new ArrayList<>());
        }
        public void addEdge(String name, String friend) {
            Person person = friends.keySet().stream().filter(e -> e.name.equals(name)).findFirst().orElse(null);
            Person friendPerson = friends.keySet().stream().filter(e -> e.name.equals(friend)).findFirst().orElse(null);
            if (person != null && friendPerson != null) {
                friends.get(person).add(friendPerson);
                friends.get(friendPerson).add(person);
            }
        }
        public List<Person> getFriends(String name) {
            return friends.keySet().stream().filter(e -> e.name.equals(name)).findFirst().map(friends::get).orElse(null);
        }

    }
    public String solution(BreathFirst.Graph graph, String name) {
        Queue<BreathFirst.Person> searchQueue = new LinkedList<>(graph.getFriends(name));
        Set<BreathFirst.Person> visited = new HashSet<>();
        while (!searchQueue.isEmpty()) {
            BreathFirst.Person person = searchQueue.poll();
            if (!visited.contains(person)) {
                if (person.isMangoSeller) {
                    return person.name;
                } else {
                    searchQueue.addAll(graph.getFriends(person.name));
                    visited.add(person);
                }
            }
        }
        return "No mango seller found";
    }

    public static void main(String[] args) {
        BreathFirst breathFirst = new BreathFirst();
        Graph graph = breathFirst.getGraph();

        System.out.println(breathFirst.solution(graph, "Bob"));
    }

    private Graph getGraph() {
        Graph graph = new Graph();
        graph.addVertex("Bob", false);
        graph.addVertex("Alice",false);
        graph.addVertex("Mark", false);
        graph.addVertex("Rob",true);
        graph.addVertex("Maria",false);
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        return graph;
    }
}
