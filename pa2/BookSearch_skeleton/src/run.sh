compile() {
	javac com/dmlab/bst/BinaryNode.java
	echo "BinaryNode Compiled"
	javac com/dmlab/bst/BinarySearchTree.java
	echo "BinarySearchTree Compiled"
	javac com/dmlab/bst/BookSearch.java
	echo "BookSearch Compiled"
	javac com/dmlab/bst/TreePrinter.java
	echo "TreePrinter Compiled"
	javac com/dmlab/Main.java
	echo "Main Compiled"
}
case $1 in
	"compile") 
		compile
		;;
	"build")
		compile
		jar -cvmf Manifest.txt PA_02_2017-16140.jar com
		echo "Make .jar"
		;;
	"run")
		java -classpath PA_02_2017-16140.jar com.dmlab.Main
		;;
	"remove")
		rm PA_02_2017-16140.jar
		;;
esac
