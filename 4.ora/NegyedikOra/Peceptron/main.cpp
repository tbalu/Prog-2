#include <iostream>
#include "mlp.hpp"
#include <png++/png.hpp>
#include <string.h>
#include <fstream>
int main(int argc, char **argv)
{
	png::image <png::rgb_pixel> png_image (argv[1]);
	png::image <png::rgb_pixel> kep (600, 600);
	  
	//int w=png_image.get_width();
	
	//int h=png_image.get_heigth();
	int size =png_image.get_width() *png_image.get_height();
	



	Perceptron* p = new Perceptron(3,size,256,size);
	
	
	double* image = new double[size];

	for ( int i {0}; i<png_image.get_width(); i++)
	   for (int j {0}; j<png_image.get_height(); j++)
		{
			image[i*png_image.get_width()+j] = png_image[i][j].red;
		}
	double value = (*p) (image);
	std::cout<<value<<std::endl;
	p->lastLayerPrinter(image);
	std::cout<<size;
	for(int k =0;k<600;k++){
		for(int l=0;l<600;l++){
			kep.set_pixel(k, l, png::rgb_pixel(image[k+l],
                                               0, 0));
}
}
 kep.write (argv[2]);
	delete p;
	delete [] image;
	
}
