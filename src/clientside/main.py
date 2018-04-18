import zmq
import time


def main():
    context = zmq.Context()
    socket = context.socket(zmq.REP)
    socket.bind("tcp://127.0.0.1:5555")
    print("Connected")
    
    while True:
        print("waiting for message...")
        message = socket.recv()
        if not message is b'exit':
            print("Received High Score Request: %s" % message)
            #socket.send(b'Send Highscore')
            #highscore = socket.recv
            #print("Received Highscore: %s" % highscore)
            #return
        elif message is b'exit':
            return
        print(message)
        #  Do some 'work'
        time.sleep(1)
    
        #  Send reply back to client
        socket.send(b'HighscoreBoard')
   
    
    
if(__name__ == "__main__"):
    main()