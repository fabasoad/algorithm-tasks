package com.fabasoad.custom;

// create TSPExample class to implement TSP code in Java
class TSPExample {
  // create findHamiltonianCycle() method to get minimum weighted cycle
  private static int findPath(int[][] distance, boolean[] visited, int currPos, int total, int count, int cost, int result) {
    if (count == total && distance[currPos][0] > 0) {
      return Math.min(result, cost + distance[currPos][0]);
    }

    // BACKTRACKING STEP
    for (int i = 0; i < total; i++) {
      if (!visited[i] && distance[currPos][i] > 0) {
        // Mark as visited
        visited[i] = true;
        result = findPath(distance, visited, i, total, count + 1, cost + distance[currPos][i], result);

        // Mark ith node as unvisited
        visited[i] = false;
      }
    }
    return result;
  }

  // main() method start
  public static void main(String[] args) {
    int total;

    //create scanner class object to get input from user
//    Scanner sc = new Scanner(System.in);

    // get total number of cities from the user
//    System.out.println("Enter total number of cities ");
//    cities = sc.nextInt();
//
//    //get distance of cities from the user
//    int[][] distance = new int[cities][cities];
//    for( int i = 0; i < cities; i++){
//      for( int j = 0; j < cities; j++){
//        System.out.println("Distance from city"+ (i+1) +" to city"+ (j+1) +": ");
//        distance[i][j] = sc.nextInt();
//      }
//    }
    total = 3;
    int[][] distance = new int[total][total];
    distance[0][0] = 0;
    distance[0][1] = 1;
    distance[0][2] = 12;
    distance[1][0] = 10;
    distance[1][1] = 0;
    distance[1][2] = 8;
    distance[2][0] = 4;
    distance[2][1] = 5;
    distance[2][2] = 0;

    // create an array of type boolean to check if a node has been visited or not
    boolean[] visited = new boolean[total];

    int startingPoint = 0;
    // by default, we make the first city visited
    visited[startingPoint] = true;

    int result = Integer.MAX_VALUE;

    // call findPath() method that returns the minimum weight Hamiltonian Cycle
    result = findPath(distance, visited, 0, total, 1, distance[startingPoint][startingPoint], result);

    // print the minimum weighted Hamiltonian Cycle
    System.out.println(result);
  }
}