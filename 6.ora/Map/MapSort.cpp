#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
 
typedef std::pair<std::string,int> pair;
 
int main()
{
    // input map
    std::map<std::string,int> map = {
        {"two", 2}, {"one", 1}, {"four", 4}, {"three", 3}
    };


std::map <std::string, int> :: iterator itr;

 std::cout << "\nA map : \n";


 for (auto const &pair: map) {
        std::cout << '{' << pair.first << "," << pair.second << '}' << '\n';
	 
	}

    // create a empty vector of pairs
    std::vector<pair> vec;
 
    // copy key-value pairs from the map to the vector
    std::copy(map.begin(),
            map.end(),
            std::back_inserter<std::vector<pair>>(vec));
 
    // a vector rendezése növekvő sorrendben a párjainak második értéke szerint
    // ha a második érték egyenlő akkor az első alapján rendezi.
    std::sort(vec.begin(), vec.end(),
            [](const pair& l, const pair& r) {
                if (l.second != r.second)
                    return l.second < r.second;
 
                return l.first < r.first;
            });
 
	std::map<std::string, int> OrderedMap;
	std::cout<<"A rendezett map"<<std::endl;

    for (auto const &pair: vec) {
        std::cout << '{' << pair.first << "," << pair.second << '}' << '\n';
	 
	}
 	


    return 0;
}
