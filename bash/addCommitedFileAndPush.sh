echo "to use this script just do: /Users/mayyaral-atari/customScripts.sh  <fileName>"
addlc(){
        echo "starting adding script"
        git add $1 && git commit -m "$1" && git push
        echo "end of adding script"
}
addlc $1
