#include <QApplication>
#include <QWidget>
#include <QGridLayout>
#include <QPushButton>
#include <QMessageBox>

int main(int argc, char *argv[])
{
    QApplication app(argc, argv);

    int n, m;
    qDebug() << "Enter the number of rows (n): ";
    std::cin >> n;
    qDebug() << "Enter the number of columns (m): ";
    std::cin >> m;

    QWidget widget;
    QGridLayout *layout = new QGridLayout(&widget);

    QVector<QVector<QPushButton *>> gridButtons(n, QVector<QPushButton *>(m, nullptr));

    for (int i = 0; i < n; ++i)
    {
        for (int j = 0; j < m; ++j)
        {
            QPushButton *button = new QPushButton(QString("(%1,%2)").arg(i).arg(j), &widget);
            connect(button, &QPushButton::clicked, [i, j]()
                    { QMessageBox::information(nullptr, "Clicked", QString("Clicked on (%1,%2)").arg(i).arg(j)); });

            layout->addWidget(button, i, j);
            gridButtons[i][j] = button;
        }
    }

    widget.setLayout(layout);
    widget.show();

    return app.exec();
}
