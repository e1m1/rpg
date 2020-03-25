package io.e1m1;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items = new ArrayList<Item>();
    private double weight = 0;

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public void putItem(Item item) {
        this.items.add(item);
        increaseWeight(item.getWeight());
    }

    public double getWeight() {
        return this.weight;
    }

    public void increaseWeight(double weight) {
        this.weight += weight;
    }

    public void decreaseWeight(double weight) {
        this.weight -= weight;
    }

    @Override
    public String toString() {
        return this.getTextTable();
    }

    public String getTextTable() {
        final char H_DIV = '=';
        final String C_DIV = "|";
        final char R_DIV = '-';
        final char X_DIV = '+';
        StringBuilder sBuilder = new StringBuilder();
        StringBuilder hStringBuilder = new StringBuilder();
        String[] columnNames = { "Name", "Weight", "Value", "Description" };
        int nameColW = columnNames[0].length();
        int wgtColW = columnNames[1].length();
        int valColW = columnNames[2].length();
        int descColW = columnNames[3].length();
        int[] columnWidths = { nameColW, wgtColW, valColW, descColW };

        for (Item item : items) {
            
            if(item.getDisplayName().length() > columnWidths[0])
                columnWidths[0] = item.getDisplayName().length();
            
            String weightStringified = ""+item.getWeight();
            if(weightStringified.length() > columnWidths[1])
                columnWidths[1] = weightStringified.length();
            
            String valueStringified = ""+item.getValue();
            if(valueStringified.length() > columnWidths[2])
                columnWidths[2] = valueStringified.length();
            
            if(item.getDescription().length() > columnWidths[3])
                columnWidths[3] = item.getDescription().length();

        }

        for(int e = 0; e < columnWidths.length; e++) {
            columnWidths[e] += 1;
        }

        for(int c = 0; c < columnNames.length; c++) {
            hStringBuilder.append(columnNames[c]);
            for(int s = 0; s < columnWidths[c] - columnNames[c].length(); s++) {
                hStringBuilder.append(' ');
            }
            hStringBuilder.append(C_DIV);
        }

        String columnHeading = hStringBuilder.toString();

        sBuilder.append(columnHeading);
        
        int totalWidth = 0;
        for(int i = 0; i < columnWidths.length; i++) {
            totalWidth += columnWidths[i];
            totalWidth += C_DIV.length();
        }

        StringBuilder hDivStringBuilder = new StringBuilder();
        String hDivLine;

        for(int i = 0; i < totalWidth; i++) {
            hDivStringBuilder.append(H_DIV);
        }

        int hDivIndex = 0;
        for(int i = 0; i < columnWidths.length; i++) {
            hDivStringBuilder.setCharAt(hDivIndex + columnWidths[i]+i, X_DIV);
            hDivIndex += columnWidths[i];
        }

        hDivLine = hDivStringBuilder.toString();
        sBuilder.append("\n").append(hDivLine);

        for(Item item : items) {
            String name = item.getDisplayName();
            double weight = item.getWeight();
            int value = item.getValue();
            String description = item.getDescription();
            
            int namePaddingAmt = columnWidths[0] - name.length();
            int weightPaddingAmt = columnWidths[1] - (""+weight).length();
            int valuePaddingAmt = columnWidths[2] - (""+value).length();
            int descPaddingAmt = columnWidths[3] - description.length();
            
            String namePadding, weightPadding, valuePadding, descPadding;

            StringBuilder namePaddingBuilder = new StringBuilder();
            StringBuilder weightPaddingBuilder = new StringBuilder();
            StringBuilder valuePaddingBuilder = new StringBuilder();
            StringBuilder descPaddingBuilder = new StringBuilder();

            for(int n = 0; n < namePaddingAmt; n++) {
                namePaddingBuilder.append(' ');
            }
            namePadding = namePaddingBuilder.toString();

            for(int w = 0; w < weightPaddingAmt; w++) {
                weightPaddingBuilder.append(' ');
            }
            weightPadding = weightPaddingBuilder.toString();

            for(int v = 0; v < valuePaddingAmt; v++) {
                valuePaddingBuilder.append(' ');
            }
            valuePadding = valuePaddingBuilder.toString();

            for(int d = 0; d < descPaddingAmt; d++) {
                descPaddingBuilder.append(' ');
            }
            descPadding = descPaddingBuilder.toString();

            sBuilder
                .append("\n")
                .append(name).append(namePadding).append(C_DIV)
                .append(weight).append(weightPadding).append(C_DIV)
                .append(value).append(valuePadding).append(C_DIV)
                .append(description).append(descPadding)
                .append("\n");
            
            for(int i = 0; i < totalWidth; i++) {
                sBuilder.append(R_DIV);
            }
        }

        sBuilder.append("\n")
                .append("Total weight: ").append(this.getWeight());

        return sBuilder.toString();
    }
}