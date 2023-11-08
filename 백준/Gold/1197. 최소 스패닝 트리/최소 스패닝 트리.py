# 최소 스패닝 트리
V, E = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(E)]
graph.sort(key=lambda x: x[2])

boss_lst = [i for i in range(V+1)]

def findboss(target):
    if boss_lst[target] == target:
        return target
    tmp = findboss(boss_lst[target])
    boss_lst[target] = tmp
    return tmp

def union(a,b):
    boss_a, boss_b = findboss(a), findboss(b)
    if boss_a == boss_b: return False
    boss_lst[boss_b] = boss_a
    return True

cnt, sum = 0, 0
for i in range(E):
    if union(graph[i][0], graph[i][1]):
        sum += graph[i][2]
        cnt += 1
    if cnt == V-1:
        break
print(sum)