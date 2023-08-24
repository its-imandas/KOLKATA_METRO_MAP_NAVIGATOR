/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author IMAN DAS
 */
import java.util.*;

class Station {
    String name;
    List<Edge> neighbors;

    public Station(String name) {
        this.name = name;
        this.neighbors = new ArrayList<>();
    }
}

class Edge {
    Station destination;
    int distance;

    public Edge(Station destination, int distance) {
        this.destination = destination;
        this.distance = distance;
    }
}

public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         // Create stations
           // Create stations
         // Create stations
        Station kaviSubhash = new Station("Kavi Subhash");
        Station shahidKhudiram = new Station("Shahid Khudiram");
        Station kaviNazrul = new Station("Kavi Nazrul");
        Station masterdaSuryaSen = new Station("Masterda Surya Sen");
        Station gitanjali = new Station("Gitanjali");
        Station netaji = new Station("Netaji");
        Station rabindraSarobar = new Station("Rabindra Sarobar");
        Station mahanayakUttamKumar = new Station("Mahanayak Uttam Kumar");
        Station jatinDasPark = new Station("Jatin Das Park");
        Station kalighat = new Station("Kalighat");
        Station netajiBhavan = new Station("Netaji Bhavan");
        // Add connections and distances
        kaviSubhash.neighbors.add(new Edge(shahidKhudiram, 3));
        shahidKhudiram.neighbors.add(new Edge(kaviNazrul, 4));
        kaviNazrul.neighbors.add(new Edge(masterdaSuryaSen, 3));
        masterdaSuryaSen.neighbors.add(new Edge(gitanjali, 2));
        gitanjali.neighbors.add(new Edge(netaji, 5));
        netaji.neighbors.add(new Edge(rabindraSarobar, 4));
        rabindraSarobar.neighbors.add(new Edge(mahanayakUttamKumar, 3));
        mahanayakUttamKumar.neighbors.add(new Edge(jatinDasPark, 4));
        jatinDasPark.neighbors.add(new Edge(kalighat, 2));
        kalighat.neighbors.add(new Edge(netajiBhavan, 3));
          // Display station names for user input
        System.out.println("Available metro stations:");
        System.out.println("1. Kavi Subhash");
        System.out.println("2. Shahid Khudiram");
        System.out.println("3. Kavi Nazrul");
        System.out.println("4. Masterda Surya Sen");
        System.out.println("5. Gitanjali");
        System.out.println("6. Netaji");
        System.out.println("7. Rabindra Sarobar");
        System.out.println("8.Mahanayak Uttam Kumar");
        System.out.println("9.Jatin Das Park");
        System.out.println("10.Kalighat");
        System.out.println("11.Netaji Bhavan");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter starting station: ");
        String startStationName = scanner.nextLine();
        System.out.print("Enter ending station: ");
        String endStationName = scanner.nextLine();

        Station startStation = findStationByName(startStationName, kaviSubhash, netajiBhavan);
        Station endStation = findStationByName(endStationName, kaviSubhash, netajiBhavan);

        if (startStation != null && endStation != null) {
            int shortestDistance = dijkstra(startStation, endStation);
            if (shortestDistance != -1) {
                System.out.println("Shortest distance: " + shortestDistance + " km");
            } else {
                System.out.println("No path found.");
            }
        } else {
            System.out.println("Invalid station names.");
        }
    }
      public static int dijkstra(Station start, Station end) {
        PriorityQueue<Edge> heap = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.distance));
        Set<Station> visited = new HashSet<>();
        Map<Station, Integer> distances = new HashMap<>();

        heap.add(new Edge(start, 0));
        distances.put(start, 0);

        while (!heap.isEmpty()) {
            Edge currentEdge = heap.poll();
            Station currentStation = currentEdge.destination;

            if (visited.contains(currentStation)) {
                continue;
            }

            visited.add(currentStation);

            if (currentStation == end) {
                return distances.get(currentStation);
            }

            for (Edge neighbor : currentStation.neighbors) {
                int newDistance = distances.get(currentStation) + neighbor.distance;
                if (newDistance < distances.getOrDefault(neighbor.destination, Integer.MAX_VALUE)) {
                    distances.put(neighbor.destination, newDistance);
                    heap.add(new Edge(neighbor.destination, newDistance));
                }
            }
        }

        return -1; // No path found
    }

    public static Station findStationByName(String name, Station... stations) {
        for (Station station : stations) {
            if (station.name.equalsIgnoreCase(name)) {
                return station;
            }
        }
        return null;
    }
}






    









    
    
    

