#pragma once
#include <iostream>
#include <algorithm>

class MemoryBlock
{

public:

	//Simple constructor that initializes the resource
	explicit MemoryBlock(size_t length)
		: _length(length)
		, _data(new int[length])
	{
	   std::cout << "In MemoryBlock(size_t). length = "
		     << _length << "."<< std::endl;
	}

	// Destructor.
	~MemoryBlock(){
	std::cout << "In ~MemoryBlock(). length ="
		  << _length << ".";
	if(_data != nullptr){
	   std::cout << "Deleting resource";
	   // Delete the resource.
	   delete[] _data;
	}

	std::cout << std::endl;
}

	// Copy constructor.
	MemoryBlock(const MemoryBlock& other)
	     : _length(other._length)
	     , _data(new int[other._length])
	{
	   std::cout << "In MemoryBlock(const MemoryBlock&). length = "
		     << other._length << ". Copying resource." << std::endl;

	   std::copy(other._data, other._data + _length, _data);
	}

	//Copy assignment operator.
	MemoryBlock& operator=(const MemoryBlock& other){
	   std:: cout << "In operator=(const MemoryBlock&). length = "
		      << other._length << ". Copying resource." <<std::endl;

	if(this != &other)
	{
	   // Free the existing resource.
	   delete[] _data;

	   _length = other._length;
	   _data = new int[_length];
	   std::copy(other._data, other._data + _length, _data);
	}
	return *this;
    }
	MemoryBlock& operator=(MemoryBlock&& other){


	std::cout << "In MemoryBlock(MemoryBlock&&). lenght"
		     << other._length << ". Moving resource." << std::endl;
	   if (this != &other)
	   {
		// Létező forrás felszabadítása
		delete[] _data;

		// Az adat mutatójának és hosszának
		// másolása a forrás objektumból
		_data = other._data;
		_length = other._length;

		// Az adat mutatójának felszabadítása a forrás
		//objektumban, hogy a destruktor ne szabadítsa fel többször a 			//memóriát.
		/*other._data = nullptr;
		other._length = 0;*/
		other.set_length(0);
		other.set_dataPointer(nullptr);
	}
	
    }
	//Retrieves the length of the data resource.
	size_t Length() const
	{
	return _length;
	}

	MemoryBlock(MemoryBlock&& other)
	    : _data(nullptr)
	    , _length(0)
	{
	   std::cout << "In MemoryBlock(MemoryBlock&&). lenght"
		     << other._length << ". Moving resource." << std::endl;
	   if (this != &other)
	   {
		// Létező forrás felszabadítása
		delete[] _data;

		// Az adat mutatójának és hosszának
		// másolása a forrás objektumból
		_data = other._data;
		_length = other._length;

		// Az adat mutatójának felszabadítása a forrás
		//objektumban, hogy a destruktor ne szabadítsa fel többször a 			//memóriát.
		other._data = nullptr;
		other._length = 0;
	}

}

	void set_length(size_t new_length)
{
		_length = new_length;
}
	void set_dataPointer(int* new_data)
{
		_data = new_data;
}
		
private:
	size_t _length;
	int* _data;
};
