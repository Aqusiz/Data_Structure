compile() {
	javac -d ../bin sort/Pair.java
	echo "Pair Compiled"
	javac -d ../bin sort/InsertionSorter.java
	echo "InsertionSorter Compiled"
	javac -d ../bin sort/QuickSorter.java
	echo "QuickSorter Compiled"
	javac -d ../bin sort/HybridSorter.java
	echo "HybridSorter Compiled"
	javac -d ../bin Main.java
	echo "Main Compiled"
}
case $1 in
	"compile") 
		compile
		;;
esac
