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

 std::cout << "\nThe map is : \n";

    std::cout << "\tKEY\tELEMENT\n";

    for (itr = map.begin(); itr != map.end(); ++itr)

    {

        std::cout  <<  '\t' << itr->first 

              <<  '\t' << itr->second << '\n';

    }

    // create a empty vector of pairs
    std::vector<pair> vec;
 
    // copy key-value pairs from the map to the vector
    std::copy(map.begin(),
            map.end(),
            std::back_inserter<std::vector<pair>>(vec));
 
    // sort the vector by increasing order of its pair's second value
    // if second value are equal, order by the pair's first value
    std::sort(vec.begin(), vec.end(),
            [](const pair& l, const pair& r) {
                if (l.second != r.second)
                    return l.second < r.second;
 
                return l.first < r.first;
            });
 
std::map<std::string, int> OrderedMap;

    // print the vector
    for (auto const &pair: vec) {
        std::cout << '{' << pair.first << "," << pair.second << '}' << '\n';
	OrderedMap.insert( pair) ;   
	}
 	


    return 0;
}
