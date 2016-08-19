package gui;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



import dataManigment.Worker;
import dataManigment.WorkerInfoHandaler;



public class WorkerMainMenu{

	// creates buttons for adding workers saving and processing on
	//to make the schedule
	private JButton addWorkerButton = new JButton("Add worker");
	private JButton saveButton = new JButton("save");
	private JButton nextButton = new JButton("Next");
	private JPanel allWorkersPanel = new JPanel();

	//needed for buttons to interact with this window
	

	


/**
 * creats a window and populates it with worker informaion
 * @param workerGuiControl
 */
	public WorkerMainMenu(){
		
		
		
		
		//creats a gruid layout largenofe to encompus all worker information 
		//and some genaral purpus buttons
		allWorkersPanel.setLayout(new GridLayout(Worker.getWorkers().size() + 1 ,4));
		
		
		/*
		 *add three elements to the grid per worker(one Row)
		 *NameLabel worker name
		 *days they have requested off 
		 *and a button to edit the worker info
		 * 
		 */
		for(final Worker worker: Worker.getWorkers()){
					
			
			JLabel NameLabel = new JLabel(worker.getSymbol());
			allWorkersPanel.add(NameLabel);
			
			JLabel DaysOff= new JLabel(worker.getRequestedOff().toString());
			allWorkersPanel.add(DaysOff);
			
			JLabel workerType = new JLabel(Worker.workerTypeTranslater(worker.getType()));
			allWorkersPanel.add(workerType);
			JButton editButton = new JButton("edit");
			allWorkersPanel.add(editButton);
			
			//assines button listener that starts the edit window
			editButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					GuiControl.getInstence().startWorkerEditWindow(worker);
				}
			});
			
			
		}
		
		// placing buttons not relevant to a specific worker
		allWorkersPanel.add(addWorkerButton);
		allWorkersPanel.add(saveButton);
		allWorkersPanel.add(nextButton);
		addButtonActions();
		
		}

/**
 * adds button action liseners and the metodes that are activated when clicked 
 * for AddWorkerButton, save Button and nextbutton
 */
	void addButtonActions(){
		//desposis of this window and starts the workerAddGui
		addWorkerButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				GuiControl.getInstence().startWorkerAddGui();
			}
		});
		//relays the command to save to the workerGuiControl
		saveButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				GuiControl.getInstence().saveStaff();
			}

		});
		// this will prosed the user to the scedual gui(not done yet)
		nextButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				saveButton.doClick();
				GuiControl.getInstence().startCalenderSettingsWindow();

			}
		});
	}
	JPanel getPanel(){
		return allWorkersPanel;
	}
}