#include <iostream>
#include <fstream>
#include <string>

std::string ReadFromFile(std::string fileName)
{
    std::string line;
    std::string res = "";
    std::ifstream in(fileName);

    if (in.is_open())
    {
        while (getline(in, line))
        {
            res = res + line + "\n";
        }
    }
    in.close();

    return res;
}

void WriteStringToFile(std::string fileName, std::string val)
{
    std::ofstream out;
    out.open(fileName);
    if (out.is_open())
    {
        out << val;
    }
}
