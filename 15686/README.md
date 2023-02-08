
# 1. 좌표 저장
- 집의 좌표(home)와 치킨집의 좌표(chicken)를 리스트에 저장해둔다.
```java

  for(int i=0; i<n; i++) {
    st = new StringTokenizer(br.readLine());
    for(int j=0; j<n; j++) {
      arr[i][j] = Integer.parseInt(st.nextToken());
      if(arr[i][j] == 2) chicken.add(new Pair(i, j));
      else if (arr[i][j]==1) home.add(new Pair(i, j));
    }
  }
    
```

# 2. 백트래킹 + 조합 
- n개 중 m개의 치킨집을 뽑는다.
- m개를 뽑았다면, 집 리스트를 순회하면서 치킨 거리와 도시의 치킨 거리를 구한다.
  이를 최소값으로 갱신하면서 문제를 풀어나간다.
  
```java
  public static void Solution(int k, int cnt) {
    if(cnt==m) { // m개를 골랐을 때 치킨집과 집과의 최솟값 구하기
      int ret=0;
      for(int i=0; i<home.size(); i++) {
        int dist=987654321; // 집과 치킨집 사이의 거리
        for(int j=0; j<chicken.size(); j++) {
          if(visit[j]) { // 선택한 치킨집
            int nx = Math.abs(chicken.get(j).x - home.get(i).x);
            int ny = Math.abs(chicken.get(j).y - home.get(i).y);
            dist = Math.min(dist, nx+ny); // 이전에 최소 거리였던 치킨 집 vs 현재 치킨 집 
          }
        }
        ret += dist;
      }
      result = Math.min(result, ret);
      return;
    }

    for(int i=k; i<chicken.size(); i++) {
      visit[i]=true;
      Solution(i+1, cnt+1);
      visit[i]=false;
    }
  }
```