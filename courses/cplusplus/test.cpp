#include <iostream>
#include <cmath>
using namespace std;

class Book
{
public: //attributes of class
    string title;
    string author;
    int pages;
    Book()
    {
    }
    Book(string aTitle, string aAuthor, int aPages) //constructor
    {
        cout << "Creating Book object";
        title = aTitle;
        author = aAuthor;
        pages = aPages;
    }
};

class EBook : public Book //inhertinance
{
public:
    string url;
    EBook(string aUrl, string aTitle, string aAuthor, int aPages)
    {
        cout << "Creating E-Book object now";
        url = aUrl;
        title = aTitle;
        author = aAuthor;
        pages = aPages;
    }
};

int main()
{
    Book book1("Harry Botter", "JK Rol", 254);
    cout << book1.author;
    EBook eBook1("https://localhost:1000", "Golden Dragon", "Mike Tomos", 100);
    cout << "\n EBook " << eBook1.url << eBook1.author << "\n";
    cout << " address for actual class obj " << &eBook1 << " EBook address for url" << &eBook1.url
         << " EBook address for author" << &eBook1.author;
    return 0;
}

// string fullName = "Tom";
// string *pFullName = &fullName; //* is the actual variable's pointer/memory address
// cout << "hello world2, waht is your name\n";
// getline(cin, fullName);
// cout << "hello " << fullName << " this is the memory "
//      << "address of the variable fullName => " << pFullName;
// int value1 = 10;
// int *pValue1 = &value1;
// cout << "\n address of value1 " << *pValue1;