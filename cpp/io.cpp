#include <iostream>
#include <string>

void print(std::string message)
{
    std::cout << message;
}

std::string input()
{
    std::string msg;
    std::cin >> msg;
    return msg;
}
