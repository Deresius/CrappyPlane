import zmq
import time
from test.test_decimal import file

def main():
    context = zmq.Context()
    socket = context.socket(zmq.REP)
    socket.bind("tcp://127.0.0.1:5555")
    e = 'High Score'
    print("Connected")
    
    while True:
        print("waiting for message...")
        message = socket.recv()
        if not message is b'exit':
            print("Received High Score Request: %s" % message)
            #myFile = file("Server Received")
            #myFile.write(message)
            
            socket.send(b'HighscoreBoard')
        elif message is b'exit':
            return
        print(message)
        #  Do some 'work'
        time.sleep(1)
    
        #  Send reply back to client
        #socket.send(b'HighscoreBoard')
   
    
    
if(__name__ == "__main__"):
    main()