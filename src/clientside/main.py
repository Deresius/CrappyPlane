import zmq
import time


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
            socket.send(b'List of Highscores')
            return            
        elif (message == b'exit'):
            print(message)
            return
        else:
            time.sleep(1)  
            socket.send(b'Not Working')
        
    
        
        
   
    
    
if(__name__ == "__main__"):
    main()