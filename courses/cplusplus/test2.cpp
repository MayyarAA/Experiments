#include <iostream>
using namespace std;
//pointer work

class PointerTestingClass
{
public:
    void run()
    {
        cout << "hello from pointer testing class\n";
        // testing();
        // testing2();
        // testing3Delete();
        testing4Memset();
    }
    void testing4Memset()
    {
        char buffer[] = {
            '1',
            '1',
            '1',
            '1',
            '1',
            '1',
            '1',
            '1',
        };
        cout << "value of buffer before ||buffer " << buffer << " \n";
        char *bufferPointer = new char[8];
        bufferPointer = buffer;
        memset(bufferPointer, '0', 8);
        cout << "value of buffer after memset ||buffer " << buffer << " \n";
    }

    void testing3Delete()
    {
        int money = 10;
        cout << "the memory address of money is &money " << &money << "\n";
        int *ptr1 = nullptr;
        ptr1 = &money;
        cout << "the memory address ptr1 is holding ptr1 " << ptr1 << "\n"
             << "the actual memory address that  ptr1 belongs to &ptr1 " << &ptr1 << "\n"
             << "the actual value being held @ the memory address that  ptr1 is holding *ptr1 " << *ptr1
             << "\n";
    }
    void testing2()
    {
        char *buffer = new char[8];
        // memset();
    }
    void testing()
    {
        void *ptr1 = nullptr;
        cout << "ptr1 " << ptr1 << "\n";
        int money = 10;
        ptr1 = &money;
        cout << "ptr1 after being assigned to money"
             << " address " << ptr1
             << " value @ that address " << &ptr1
             << "\n";

        //now we will get the value stored @ the address that ptr1 is storing,
        //the address ptr1 is saving is the memory location that is holding the
        //value of money
        cout << "value of money before change " << money << "\n";
        int *ptr2 = &money; //money=10
        *ptr2 = 5;
        cout << " value of money after ptr2 changed it " << money
             << "\n";
    }
};

int main()
{
    cout << "hello from test2\n";

    PointerTestingClass pointerTestingClass;
    pointerTestingClass.run();
    return 0;
}