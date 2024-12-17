# SymmetricTree
https://leetcode.com/problems/symmetric-tree/description/

이진트리의 root 가 주어졌을 때 해당 트리가 대칭적인지 아닌지 판단하는 문제. \
문제 카테고리가 BFS 여서 iterative 하게 풀었는데,, 사실 DFS 로 푸는 편이 더 깔끔할 것 같은 문제이다. \
DFS 로 푼다면 제귀 조각을 leftSubtree -> left 와 rightSubtree -> right, leftSubtree -> right 와 
rightSubtree -> left 를 비교하도록 만들면 된다.
![img.png](img.png)