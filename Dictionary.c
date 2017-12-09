#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include "tiny_dict.h"

/*Function Get Definition*/
dict_entry get_definition()
{
 int i;
 dict_entry out_entry;
 printf("\n Enter keyword: ");
 gets(out_entry.keyword);
 printf("\n Enter definition of up to %d lines.", SENTENCE_MAX);
 for(i = 0; i < SENTENCE_MAX; i++)
 {
     printf("\n Line %d :", i+1);
     gets(out_entry.sentence[i]);
 }
 return(out_entry);
}
//Function display entry//
void display_entry(dict_entryp display_rec){
    int i;
    printf("Keyword: %s\n", display_rec ->keyword);
    for(i =0; i<SENTENCE_MAX;i++){
        printf("%s\n", display_rec ->sentence[i]);
    }
}
//list entries
void list_entries()
{
    int i;
    printf("Dictionary Entries \n");
    for(i=0; i<entry_count; i++)
        printf("%s\n",dictionary[i].keyword);
    printf("****** End of Entries ***** \n");
}
//function find entry//
int find_entry(char *keyword)
{
    int i;
    for(i =0; i <entry_count; i++)
    {
        if(!(strcmp(keyword,dictionary[i].keyword)))
            return(i);
    }
    return(-1);
}
//main function//
void main()
{
    int done = 0;
    int choice = 0, idx = 0;
    char display_kw[80];
    while(!done)
    {
        printf("<<< Your - Webster >>>");
        printf("\n1 enter a definition \n");
        printf("2 list all entries \n");
        printf("3 display an entry. \n");
        printf("4 exit \n");
        printf("Choices : ");
        scanf("%d", &choice);
        fflush(stdin);

        switch(choice)
        {
        case 1:
            if(entry_count <ENTRY_MAX)
            {
                dictionary[entry_count] = get_definition();
                entry_count++;
            }else
            printf("\n %d is Maximum number of entries! \n", ENTRY_MAX);
            break;
        case 2:
            list_entries();
            break;
        case 3:
            printf("\n Enter a keyword to display : ");
            gets(display_kw);
            if((idx = find_entry(display_kw))>=0)
                display_entry(&(dictionary[idx]));
            else
                printf("\n %s not found. \n", display_kw);
            break;
        case 4:
            done = 1;
            break;
        default:
            printf("\nInvalid choice, try again");
        }
    }
}
