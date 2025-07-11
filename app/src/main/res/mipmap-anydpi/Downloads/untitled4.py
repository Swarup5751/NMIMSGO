# -*- coding: utf-8 -*-
"""Untitled4.ipynb

Automatically generated by Colab.

Original file is located at
    https://colab.research.google.com/drive/1DVZ9098DivgVp-6urjNnNi0Wse4ah9Ws
"""

import heapq

class Node:
    def __init__(self, state, parent, cost, heuristic):
        self.state = state
        self.parent = parent
        self.cost = cost
        self.heuristic = heuristic

    def __lt__(self, other):
        return self.heuristic < other.heuristic

def greedy_bfs(start, goal, heuristic_function):
    open_list = []
    closed_list = set()

    start_node = Node(start, None, 0, heuristic_function(start, goal))
    heapq.heappush(open_list, start_node)

    while open_list:
        current_node = heapq.heappop(open_list)

        if current_node.state == goal:
            path = []
            while current_node:
                path.append(current_node.state)
                current_node = current_node.parent
            return path[::-1]

        closed_list.add(current_node.state)

        for (neighbour, cost) in get_neighbours(current_node.state):
            if neighbour in closed_list:
                continue

            neighbour_node = Node(neighbour, current_node, current_node.cost + cost, heuristic_function(neighbour, goal))
            heapq.heappush(open_list, neighbour_node)

    return None

def get_neighbours(state):
    """
    Returns a list of neighbours and their costs for a given state.

    This is a placeholder, replace it with your specific graph structure.
    """

    graph = {
        'A': [('B', 1), ('C', 3)],
        'B': [('D', 5)],
        'C': [('D', 1), ('G', 10)],
        'D': [('G', 2)],
        'G': []
    }

    return graph.get(state, [])


def heuristic_function(state, goal):

    return 0

start_state = 'A'
goal_state = 'G'
path = greedy_bfs(start_state, goal_state, heuristic_function)
print("Path:", path)

import heapq

class Node:
    def __init__(self, state, parent, cost, heuristic):
        self.state = state
        self.parent = parent
        self.cost = cost
        self.heuristic = heuristic

    def __lt__(self, other):
        return self.heuristic < other.heuristic

def greedy_bfs(start, goal, heuristic_function):
    open_list = []
    closed_list = set()

    start_node = Node(start, None, 0, heuristic_function(start, goal))
    heapq.heappush(open_list, start_node)

    while open_list:
        current_node = heapq.heappop(open_list)

        if current_node.state == goal:
            path = []
            while current_node:
                path.append(current_node.state)
                current_node = current_node.parent
            return path[::-1]

        closed_list.add(current_node.state)

        for (neighbour, cost) in get_neighbours(current_node.state):
            if neighbour in closed_list:
                continue

            neighbour_node = Node(neighbour, current_node, current_node.cost + cost, heuristic_function(neighbour, goal))
            heapq.heappush(open_list, neighbour_node)

    return None

def get_neighbours(state):

    pass

def heuristic_function(state, goal):

    pass


start_state = 'A'
goal_state = 'G'
path = greedy_bfs(start_state, goal_state, heuristic_function)
print("Path:", path)