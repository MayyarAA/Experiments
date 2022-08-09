#include <iostream>
#include <cmath>
using namespace std;

class Book
{
public: //attributes of class
    string title;
    string author;
    int pages;
    Book(string aTitle, string aAuthor, int aPages) //constructor
    {
        cout << "Creating Book object";
        title = aTitle;
        author = aAuthor;
        pages = aPages;
    }
};

int main()
{
    // string fullName = "Tom";
    // string *pFullName = &fullName; //* is the actual variable's pointer/memory address
    // cout << "hello world2, waht is your name\n";
    // getline(cin, fullName);
    // cout << "hello " << fullName << " this is the memory "
    //      << "address of the variable fullName => " << pFullName;
    // int value1 = 10;
    // int *pValue1 = &value1;
    // cout << "\n address of value1 " << *pValue1;
    Book book1("Harry Botter", "JK Rol", 254);
    cout << book1.author;
    return 0;
}