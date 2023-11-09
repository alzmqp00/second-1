#include <bits/stdc++.h>
#define MAX_STACK_SIZE 1000;

using namespace std;

typedef struct
{
    int vert;
    int horiz;
} offsets;
typedef struct
{
    int row;
    int col;
    int dir;
} element;

stack<element> s;
vector<vector<bool>> visited;

void path(vector<vector<int>> maze, offsets move[])
{
    int n = maze.size();
    int m = maze[0].size();
    visited.assign(n, vector<bool>(m, false));

    s.push({1, 1, 0});

    // row col dir
    while (!s.empty())
    {
        visited[s.top().row][s.top().col] = 1;
        int row = s.top().row;
        int col = s.top().col;
        bool findpath = false;
        if (maze[row][col] == 3)
        {
            printf("Found the exit!\n");
            break;
        }
        int count = -1;
        for (int i = -1; i <= 1; i++)
        {
            for (int j = -1; j <= 1; j++)
            {
                int newRow = row + i;
                int newCol = col + j;
                count++;
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
                    visited[newRow][newCol] != 1 && maze[newRow][newCol] != 1 && (j != 0 || i != 0))
                {
                    s.push(element{newRow, newCol, count});
                    visited[newRow][newCol] = 1;
                    findpath = true;
                    break;
                }
            }
            if (findpath)
            {
                break;
            }
        }

        if (!findpath)
        {
            if (!s.empty())
                s.pop();
            if (!s.empty())
            {
                row += move[s.top().dir].vert;
                col += move[s.top().dir].horiz;
            }
        }
    }
}

int main()
{
    offsets move[8];
    move[0].vert = -1;
    move[0].horiz = -1;
    move[1].vert = -1;
    move[1].horiz = 0;
    move[2].vert = -1;
    move[2].horiz = 1;
    move[3].vert = 0;
    move[3].horiz = -1;
    move[4].vert = 0;
    move[4].horiz = 1;
    move[5].vert = 1;
    move[5].horiz = -1;
    move[6].vert = 1;
    move[6].horiz = 0;
    move[7].vert = 1;
    move[7].horiz = 1;

    vector<vector<int>> maze = {
        {1, 1, 1, 1, 1, 1, 1, 1},
        {1, 2, 1, 1, 1, 1, 0, 1},
        {1, 0, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 0, 3, 1},
        {1, 1, 1, 1, 1, 1, 1, 1}};

    path(maze, move);

    return 0;
}
