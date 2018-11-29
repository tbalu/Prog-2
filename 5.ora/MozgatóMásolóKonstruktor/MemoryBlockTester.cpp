#include "MemoryBlock.h"
#include <vector>

using namespace std;

int main(){
	
	vector<MemoryBlock> v;
	std::cout << "Első elem behelyezése" << std::endl;
	v.push_back(MemoryBlock(25));
	std::cout << "Második elem behelyezése " << std::endl;
	v.push_back(MemoryBlock(75));
	
 	std::cout << "Új elemet helyezünk a vektor második helyére" << endl;
	// Új elemet helyezünk a vektor második poziciójába.
	v.insert(v.begin() + 1,MemoryBlock(50)); 
	
}
