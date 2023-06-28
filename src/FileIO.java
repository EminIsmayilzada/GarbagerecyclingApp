
import java.io.*;
import java.util.Scanner;
public class FileIO {
    static int capacity = 450;

    public static TrashCan<Garbage> readTrashCan() {
        TrashCan<Garbage> trash = new TrashCan<Garbage>();
        File file = new File("garbage.txt");
        Scanner reader;
        try {
            reader = new Scanner(file);
            while(reader.hasNextLine() && capacity > 0) {
                String data = reader.nextLine();
                String[] lines = data.split(",");
                String nameOfTheTrash = lines[0];
                String typeOfTheTrash = lines[1];
                int sizeOfTheTrash = Integer.parseInt(lines[2].toString());
                Garbage gar = new Garbage(nameOfTheTrash,typeOfTheTrash,sizeOfTheTrash);
                trash.add(gar);
                capacity-=sizeOfTheTrash;
            }

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        System.out.println("Trash Can:");
        trash.displayItems();
        System.out.println("----------------------------------------------------");
        return trash;
    }

    public static boolean updateTrashCan() {
        //The code in this function is so bulky, because we were not allowed to create other functions, but only two function. If and if elses could be written as a function:)
        FabricRecycleBin<Garbage> fabricRecycleBin = new FabricRecycleBin<Garbage>();
        GlassRecycleBin<Garbage> glassRecycleBin = new GlassRecycleBin<Garbage>();
        MetalRecycleBin<Garbage> metalRecycleBin = new MetalRecycleBin<Garbage>();
        OrganicRecycleBin<Garbage> organicRecycleBin = new OrganicRecycleBin<Garbage>();
        PaperRecycleBin<Garbage> paperRecycleBin = new PaperRecycleBin<Garbage>();
        PlasticRecycleBin<Garbage> plasticRecycleBin = new PlasticRecycleBin<Garbage>();

        TrashCan<Garbage> trash = readTrashCan();
        TrashCan<Garbage> trash2 = new TrashCan<Garbage>();


        int fabricSize = fabricRecycleBin.getSize();
        int glassSize = glassRecycleBin.getSize();
        int metalSize = metalRecycleBin.getSize();
        int organicSize = organicRecycleBin.getSize();
        int paperSize = paperRecycleBin.getSize();
        int plasticSize = plasticRecycleBin.getSize();

        int index = 0;
        for (int i = 0; i <trash.getItemCount(); i++) {
            trash.transferTo(trash2, trash.get(i));
        }
        while(index < trash.getItemCount()) {
            if(trash.get(index).getType().equals("fabric") && fabricSize > 0) {
                if(fabricSize > trash.get(index).getSize()) {
                    fabricRecycleBin.add(trash.get(index));
                    trash2.remove(trash.get(index));
                }
                else {
                    Garbage temp = new Garbage(trash.get(index).getName(),trash.get(index).getType(),trash.get(index).getSize() - fabricSize);
                    trash.get(index).setSize(fabricSize);
                    fabricRecycleBin.add(trash.get(index));
                    trash2.remove(trash.get(index));
                    trash2.add(temp);
                }
                fabricSize-=trash.get(index).getSize();
            }

            else if(trash.get(index).getType().equals("glass") && glassSize > 0 ) {
                if(glassSize > trash.get(index).getSize()) {
                    glassRecycleBin.add(trash.get(index));
                    trash2.remove(trash.get(index));
                }
                else {
                    Garbage temp = new Garbage(trash.get(index).getName(),trash.get(index).getType(),trash.get(index).getSize() - glassSize);
                    trash.get(index).setSize(glassSize);
                    glassRecycleBin.add(trash.get(index));
                    trash2.remove(trash.get(index));
                    trash2.add(temp);
                }
                glassSize -= trash.get(index).getSize();
            }

            else if(trash.get(index).getType().equals("metal") && metalSize > 0) {
                if(metalSize > trash.get(index).getSize()) {
                    metalRecycleBin.add(trash.get(index));
                    trash2.remove(trash.get(index));
                }
                else {
                    Garbage temp = new Garbage(trash.get(index).getName(),trash.get(index).getType(),trash.get(index).getSize() - metalSize);
                    trash.get(index).setSize(metalSize);
                    metalRecycleBin.add(trash.get(index));
                    trash2.remove(trash.get(index));
                    trash2.add(temp);
                }
                metalSize -= trash.get(index).getSize();

            }

            else if(trash.get(index).getType().equals("organic") && organicSize > 0) {
                if(organicSize > trash.get(index).getSize()) {
                    organicRecycleBin.add(trash.get(index));
                    trash2.remove(trash.get(index));
                }
                else {
                    Garbage temp = new Garbage(trash.get(index).getName(),trash.get(index).getType(),trash.get(index).getSize() - organicSize);
                    trash.get(index).setSize(organicSize);
                    organicRecycleBin.add(trash.get(index));
                    trash2.remove(trash.get(index));
                    trash2.add(temp);
                }
                organicSize -= trash.get(index).getSize();
            }

            else if(trash.get(index).getType().equals("paper") && paperSize > 0) {
                if(paperSize > trash.get(index).getSize()) {
                    paperRecycleBin.add(trash.get(index));
                    trash2.remove(trash.get(index));
                }
                else {
                    Garbage temp = new Garbage(trash.get(index).getName(),trash.get(index).getType(),trash.get(index).getSize() - paperSize);
                    trash.get(index).setSize(paperSize);
                    paperRecycleBin.add(trash.get(index));
                    trash2.remove(trash.get(index));
                    trash2.add(temp);
                }
                paperSize -= trash.get(index).getSize();
            }

            else if(trash.get(index).getType().equals("plastic") && plasticSize > 0) {
                if(plasticSize > trash.get(index).getSize()) {
                    plasticRecycleBin.add(trash.get(index));
                    trash2.remove(trash.get(index));
                }
                else {
                    Garbage temp = new Garbage(trash.get(index).getName(),trash.get(index).getType(),trash.get(index).getSize() - plasticSize);
                    trash.get(index).setSize(plasticSize);
                    plasticRecycleBin.add(trash.get(index));
                    trash2.remove(trash.get(index));
                    trash2.add(temp);
                }
                plasticSize -= trash.get(index).getSize();
            }
            index++;
        }
        System.out.println("Fabric Recycle Bin: ");
        System.out.println("Size: " + fabricRecycleBin.getSize());
        fabricRecycleBin.displayItems();
        System.out.println("---------------------------------------------------");
        System.out.println("Glass recycle Bin:");
        System.out.println("Size: " + glassRecycleBin.getSize());
        glassRecycleBin.displayItems();
        System.out.println("---------------------------------------------------");
        System.out.println("Metal recycle Bin:");
        System.out.println("Size: " + metalRecycleBin.getSize());
        metalRecycleBin.displayItems();
        System.out.println("---------------------------------------------------");
        System.out.println("Organic recycle Bin:");
        System.out.println("Size: " + organicRecycleBin.getSize());
        organicRecycleBin.displayItems();
        System.out.println("---------------------------------------------------");
        System.out.println("Paper recycle Bin:");
        System.out.println("Size: " + paperRecycleBin.getSize());
        paperRecycleBin.displayItems();
        System.out.println("---------------------------------------------------");
        System.out.println("Plastic recycle Bin:");
        System.out.println("Size: " + plasticRecycleBin.getSize());
        plasticRecycleBin.displayItems();
        System.out.println("---------------------------------------------------");
        System.out.println("Updated Trash Can:");
        System.out.println(trash2.getItemCount());
        trash2.displayItems();

        FileWriter writer = null;
        try {
            File file = new File("updatedOutput.txt");

            writer = new FileWriter(file);

            for(int i=0; i<trash2.getItemCount(); i++){
                if(trash2.get(i) != null) {
                    writer.write(trash2.get(i).toString());
                    writer.write("\n");
                }
            }
            writer.flush();
            writer.close();

            System.out.println("Data has been written to the file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Failed to close the writer: " + e.getMessage());
                }
            }
        }
        return true;
    }
}