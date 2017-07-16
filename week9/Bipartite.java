public boolean isBipartite(List<GraphNode> graph) {
  if(graph == null || graph.size() <= 2) {
    return true;
  }

  HashMap<GraphNode, Information> map = new HashMap<>();

  for(GraphNode gn : graph) { //outer loop: find the access node in different clouds
    if(gn.neighbors.size() == 0 || map.get(gn) != null) { //we don't care about those independent nodes 
      continue;                                         //or nodes in the clouds we visited before
    }

    if(!isBipartiteCloud(map, gn)) {
      return false;
    }
  }

  return true;
}

private boolean isBipartiteCloud(HashMap<GraphNode, Information> map, GraphNode start) {
  Queue<GraphNode> q = new LinkedList<>();

  map.put(start, new Information(1));
  q.offer(start);

  while(!q.isEmpty()) {
    GraphNode cur = q.poll();
    map.get(cur).expanded = true;

    for(GraphNode neighbor : cur.neighbors) { //check if all neighbors are in the other group
      Information neighborInfo = map.get(neighbor);
      int curGroup = map.get(cur).group;

      if(neighborInfo == null) { // this node is never explored before
        map.put(neighbor, new Information(curGroup == 1 ? 2 : 1)); // we simply put this node to the other group
      }
      else{ //if we explored this node before, this node must have a group, we check whether they are in different groups
        if(neighborInfo.group == curGroup) {
          return false;
        }
      }
      
      //if this node hasn't been expanded, we put it into the queue
      if(!map.get(neighbor).expanded) { //note: has to be map.get(neighbor) because neighborInfo could be null
        q.offer(neighbor);
      }
    }
  }

  return true;
}

public class Information {
  public boolean expanded = false;
  public int group; //1 and 2 represents its group

  public Information(int group) {
    this.group = group;
  }
}
