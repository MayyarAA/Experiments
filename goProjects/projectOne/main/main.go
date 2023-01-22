package main

import "fmt"
import "rsc.io/quote"

func main(){
	fmt.Println(" ss")	
	fmt.Println(quote.Go())

	// declaring vars
	var v1,v2 int = 10, 22;
	v3 := "v3 variable shorthand declared"
	fmt.Println(v1);
	fmt.Println(v2);
	fmt.Println(v3);	
	// secondHelperExampleForLoop()
	methodWIfExample(10)
}

// if example
func methodWIfExample(data int){
	if data % 2 == 0 {
		fmt.Println("The data given is event: ", data)
	}
}

// for example
func secondHelperExampleForLoop(){
	// go's looping construct: only has forloops

	for i:=0; i< 10; i++{
		fmt.Println("via loop prinring: ", i)
	}
}
