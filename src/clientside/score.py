'''
Created on Apr 16, 2018

@author: timbe
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