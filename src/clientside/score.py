'''
Created on Apr 16, 2018

@author: Group 4
'''

class Score(object):
    '''
    classdocs
    '''

    def __init__(self, name, thescore):
        '''
        Constructor
        '''
        self.name = name
        self.thescore = thescore
        
        
    def getScore(self):
        return self.thescore
    
    def getName(self):
        return self.name
    
    def __lt__(self, other):
        return self.getScore() > other.getScore()
    
    
    
    
    
    