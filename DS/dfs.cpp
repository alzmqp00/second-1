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
// 一開始忘記指定大小
void path(vector<vector<char>> maze, offsets move[])
{
    int n = maze.size();
    int m = maze[0].size();
    visited.assign(n, vector<bool>(m, false)); // n->m
    int row;
    int col;

    s.push({1, 1, 0});

    // row col dir
    while (!s.empty())
    {
        visited[s.top().row][s.top().col] = 1;
        row = s.top().row;
        col = s.top().col;

        bool findpath = 0;
        if (maze[row][col] == '3')
        {

            for (int i = 0; i < maze.size(); i++)
            {
                for (int j = 0; j < maze[0].size(); j++)
                {
                    if (j != 0 && i != 0 && i != maze.size() - 1 && j != maze[0].size() - 1)
                        printf("%c", maze[i][j]);
                }
                printf("\n");
            }
            return;
        }
        maze[row][col] = '*';
        int count = -1;
        for (int i = -1; i <= 1; i++)
        {
            for (int j = -1; j <= 1; j++)
            {
                count++;
                if (visited[row + i][col + j] != 1 && maze[row + i][col + j] != '1' && (j != 0 || i != 0))
                {
                    s.push(element{(row + i), col + j, count});
                    visited[s.top().row][s.top().col] = 1;
                    findpath = 1;
                    break;
                }
            }
            if (findpath)
            {
                break;
            }
        }

        if (findpath == 0 && !s.empty())
        {
            maze[row][col] = '0';
            row += move[s.top().dir].vert;
            col += move[s.top().dir].horiz;

            s.pop();
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

    int n = 100, m = 200;
    vector<vector<char>> maze = {
        {'1', '1', '1', '1', '1', '1', '1', '1'},
        {'1', '@', '1', '1', '1', '1', '0', '1'},
        {'1', '1', '0', '1', '1', '1', '1', '1'},
        {'1', '0', '0', '0', '0', '0', '3', '1'},
        {'1', '1', '1', '1', '1', '1', '1', '1'}};
    path(maze, move);

    return 0;
}