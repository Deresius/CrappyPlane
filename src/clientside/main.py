import zmq
import time
from clientside import scoreboard


def main():
    context = zmq.Context()
    socket = context.socket(zmq.REP)
    socket.bind("tcp://127.0.0.1:5555")
    print("Connected")
    
    while True:
        message = socket.recv()
        if (message == b'highscore'):
            print("Received High Score Request: %s" % message)
            socket.send(b'Send Highscore')
            time.sleep(1)
            message = socket.recv()
            print("Received: %s" % message)
            time.sleep(1)
            myScores = scoreboard.HighScores('highscores')
            returnString = "\n"
            for item in myScores.getScores():
                returnString += item.getName() + "," + str(item.getScore()) + "\n"
            socket.send(returnString.encode(encoding='utf_8', errors='strict'))
            return
        elif (message == b'exit'):
            print(message)
            return
        else:
            time.sleep(1)  
            socket.send(b'Not Working')
        
    
        
        
   
    
    
if(__name__ == "__main__"):
    main()