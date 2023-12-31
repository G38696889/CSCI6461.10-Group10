
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import Sample.InstructionWord;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;
import java.util.*;
import java.lang.*;
import java.lang.invoke.ConstantCallSite;

public class HelloWorld {
	private static JFrame frame;
	private static JPanel panel;
	private static JTextField oprInput;
	private static JTextField gprInput;
	private static JTextField ixrInput;
	private static JTextField addrInput;
	private static JButton runBtn;
	private static JLabel gpr0Lbl;
	private static JLabel gpr1Lbl;
	private static JLabel gpr2Lbl;
	private static JLabel gpr3Lbl;
	private static JLabel gpr0ValueLbl;
	private static JLabel gpr1ValueLbl;
	private static JLabel gpr2ValueLbl;
	private static JLabel gpr3ValueLbl;
	private static JTextField indexInput;
	private static JLabel oprInputLbl;
	private static JLabel gprInputLbl;
	private static JLabel ixrInputLbl;
	private static JLabel indexInputLbl;
	private static JLabel addrInputLbl;
	private static JButton loadBtn;
	private static JLabel ixr1Lbl;
	private static JLabel ixr2Lbl;
	private static JLabel ixr3Lbl;
	private static JLabel ixr1ValueLbl;
	private static JLabel ixr2ValueLbl;
	private static JLabel ixr3ValueLbl;

	private static JButton gpr0LoadBtn;
	private static JButton gpr2LoadBtn;
	private static JButton gpr1LoadBtn;
	private static JButton gpr3LoadBtn;

	private static JButton ixr1LoadBtn;
	private static JButton ixr2LoadBtn;
	private static JButton ixr3LoadBtn;
	private static Map<String, String> gprInputMux = new HashMap();
	private static ArrayList<InstructionWord> words;
	

	private static JLabel pcLbl;
	private static JLabel marLbl;
	private static JLabel mbrLbl;
	private static JLabel irLbl;
	private static JLabel mfrLbl;
	private static JLabel prvlgLbl;

	private static JLabel pcValueLbl;

	private static String gprText;
	private static JLabel marValueLbl;
	private static JLabel mbrValueLbl;
	private static JLabel irValueLbl;
	private static JLabel mfrValueLbl;
	private static JLabel prvlgValueLbl;

	private static JButton pcLoadBtn;
	private static JButton marLoadBtn;
	private static JButton irLoadBtn;

	private static JDialog errorDialogBox;

	public static void main(String[] args) {

		InitializeFrameComponents();
		SetMapValues();
		SetDefaultValues();
		SetActions();
	}

	private static void SetActions() {
		loadBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FileHandler newfileFileHandler = new FileHandler();
				try {
					newfileFileHandler.LoadFile();
					words = newfileFileHandler.ConvertTheFile();
				} catch (Exception ex) {
					ShowError(ex.getMessage());
				}

			}
		});
		runBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gprUserInput = gprInput.getText();
				if (!gprUserInput.isEmpty()) {
					SetDefaultValues();
					switch (gprUserInput) {
					case "00":
						gpr0ValueLbl.setText(addrInput.getText());
						break;
					case "01":
						gpr1ValueLbl.setText(addrInput.getText());
						break;
					case "10":
						gpr2ValueLbl.setText(addrInput.getText());
						break;
					case "11":
						gpr3ValueLbl.setText(addrInput.getText());
						break;
					default:
						ShowError("Error in gpr input.");
					}
				}
			}
		});

		gpr0LoadBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					gprText = LoadGPR();
					gpr0ValueLbl.setText(gprText);
				} catch (Exception e1) {
					gpr0ValueLbl.setText(Constants.default16Zeroes);
					ShowError(e1.getMessage());
				}
			}
		});

		gpr1LoadBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					gprText = LoadGPR();
					gpr1ValueLbl.setText(gprText);
				} catch (Exception e1) {
					gpr1ValueLbl.setText(Constants.default16Zeroes);
					ShowError(e1.getMessage());
				}
			}
		});

		gpr2LoadBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					gprText = LoadGPR();
					gpr2ValueLbl.setText(gprText);
				} catch (Exception e1) {
					gpr2ValueLbl.setText(Constants.default16Zeroes);
					ShowError(e1.getMessage());
				}
			}
		});

		gpr3LoadBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					gprText = LoadGPR();
					gpr3ValueLbl.setText(gprText);
				} catch (Exception e1) {
					gpr3ValueLbl.setText(Constants.default16Zeroes);
					ShowError(e1.getMessage());
				}
			}
		});
	}

	private static void InitializeFrameComponents() {
		frame = new JFrame("Group 10");
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setSize(840, 460);
		frame.getContentPane().setLayout(null);

		// Labels
		gpr0Lbl = new JLabel("GPR0");
		gpr0Lbl.setHorizontalAlignment(SwingConstants.LEFT);
		gpr0Lbl.setForeground(Color.black);
		gpr0Lbl.setBounds(86, 40, 33, 14);

		gpr0ValueLbl = new JLabel();
		gpr0ValueLbl.setBounds(130, 40, 173, 20);
		gpr0ValueLbl.setForeground(SystemColor.activeCaptionText);
		gpr0ValueLbl.setFont(new Font("Calibri", Font.BOLD, 18));

		gpr1Lbl = new JLabel("GPR1");
		gpr1Lbl.setForeground(Color.black);
		gpr1Lbl.setBounds(86, 70, 33, 14);

		gpr1ValueLbl = new JLabel();
		gpr1ValueLbl.setBounds(129, 70, 164, 20);
		gpr1ValueLbl.setForeground(SystemColor.activeCaptionText);
		gpr1ValueLbl.setFont(new Font("Calibri", Font.BOLD, 18));

		gpr2Lbl = new JLabel("GPR2");
		gpr2Lbl.setBounds(86, 100, 33, 14);
		gpr2Lbl.setForeground(Color.black);

		gpr2ValueLbl = new JLabel();
		gpr2ValueLbl.setBounds(129, 100, 164, 20);
		gpr2ValueLbl.setForeground(SystemColor.activeCaptionText);
		gpr2ValueLbl.setFont(new Font("Calibri", Font.BOLD, 18));

		gpr3Lbl = new JLabel("GPR3");
		gpr3Lbl.setBounds(86, 130, 33, 14);
		gpr3Lbl.setForeground(Color.black);

		gpr3ValueLbl = new JLabel();
		gpr3ValueLbl.setBounds(128, 130, 164, 20);
		gpr3ValueLbl.setForeground(SystemColor.activeCaptionText);
		gpr3ValueLbl.setFont(new Font("Calibri", Font.BOLD, 18));

		ixr1Lbl = new JLabel("IXR 1");
		ixr1Lbl.setBounds(86, 165, 46, 14);
		ixr1Lbl.setForeground(Color.black);

		ixr2Lbl = new JLabel("IXR 2");
		ixr2Lbl.setBounds(86, 195, 46, 14);
		ixr2Lbl.setForeground(Color.black);

		ixr3Lbl = new JLabel("IXR 3");
		ixr3Lbl.setBounds(86, 225, 46, 14);
		ixr3Lbl.setForeground(Color.black);

		ixr1ValueLbl = new JLabel();
		ixr1ValueLbl.setBounds(129, 165, 209, 20);
		ixr1ValueLbl.setForeground(SystemColor.activeCaptionText);
		ixr1ValueLbl.setFont(new Font("Calibri", Font.BOLD, 18));

		ixr2ValueLbl = new JLabel();
		ixr2ValueLbl.setBounds(129, 195, 209, 20);
		ixr2ValueLbl.setForeground(SystemColor.activeCaptionText);
		ixr2ValueLbl.setFont(new Font("Calibri", Font.BOLD, 18));

		ixr3ValueLbl = new JLabel();
		ixr3ValueLbl.setBounds(129, 225, 209, 20);
		ixr3ValueLbl.setForeground(SystemColor.activeCaptionText);
		ixr3ValueLbl.setFont(new Font("Calibri", Font.BOLD, 18));

		oprInput = new JTextField();
		oprInput.setBounds(126, 265, 86, 20);
		oprInput.setColumns(10);

		oprInputLbl = new JLabel("Operation");
		oprInputLbl.setBounds(146, 290, 66, 14);

		gprInput = new JTextField();
		gprInput.setBounds(222, 265, 40, 20);
		gprInput.setColumns(2);

		gprInputLbl = new JLabel("GPR");
		gprInputLbl.setBounds(232, 290, 26, 14);

		ixrInput = new JTextField();
		ixrInput.setBounds(272, 265, 38, 20);
		ixrInput.setColumns(10);

		ixrInputLbl = new JLabel("IXR");
		ixrInputLbl.setBounds(285, 290, 28, 14);

		indexInput = new JTextField();
		indexInput.setBounds(320, 265, 18, 20);
		indexInput.setColumns(10);

		indexInputLbl = new JLabel("I");
		indexInputLbl.setBounds(327, 290, 4, 14);

		addrInputLbl = new JLabel("Address");
		addrInputLbl.setBounds(371, 290, 63, 14);

		addrInput = new JTextField();
		addrInput.setBounds(348, 265, 86, 20);
		addrInput.setColumns(10);

		pcLbl = new JLabel("PC");
		pcLbl.setBounds(475, 40, 46, 14);

		pcValueLbl = new JLabel(Constants.default12Zeroes);
		pcValueLbl.setBounds(545, 40, 164, 20);
		pcValueLbl.setFont(new Font("Calibri", Font.BOLD, 18));

		marLbl = new JLabel("MAR");
		marLbl.setBounds(475, 70, 46, 14);

		marValueLbl = new JLabel(Constants.default12Zeroes);
		marValueLbl.setBounds(545, 70, 164, 20);
		marValueLbl.setFont(new Font("Calibri", Font.BOLD, 18));

		mbrLbl = new JLabel("MBR");
		mbrLbl.setBounds(475, 106, 46, 14);

		mbrValueLbl = new JLabel(Constants.default16Zeroes);
		mbrValueLbl.setBounds(545, 100, 200, 20);
		mbrValueLbl.setFont(new Font("Calibri", Font.BOLD, 18));

		irLbl = new JLabel("IR");
		irLbl.setBounds(475, 136, 46, 14);

		irValueLbl = new JLabel(Constants.default16Zeroes);
		irValueLbl.setBounds(545, 130, 200, 20);
		irValueLbl.setFont(new Font("Calibri", Font.BOLD, 18));

		mfrLbl = new JLabel("MFR");
		mfrLbl.setBounds(475, 160, 46, 14);

		mfrValueLbl = new JLabel(Constants.default4Zeroes);
		mfrValueLbl.setBounds(545, 160, 46, 20);
		mfrValueLbl.setFont(new Font("Calibri", Font.BOLD, 18));

		prvlgLbl = new JLabel("Privliged");
		prvlgLbl.setBounds(475, 190, 58, 14);

		prvlgValueLbl = new JLabel(Constants.defaultSingleZero);
		prvlgValueLbl.setBounds(545, 190, 46, 20);
		prvlgValueLbl.setFont(new Font("Calibri", Font.BOLD, 18));

		// Buttons
		gpr0LoadBtn = new JButton("LD");
		gpr0LoadBtn.setFont(new Font("Tahoma", Font.PLAIN, 9));
		gpr0LoadBtn.setBounds(300, 40, 18, 14);
		gpr0LoadBtn.setMargin(new Insets(0, 0, 0, -3));

		gpr1LoadBtn = new JButton("LD");
		gpr1LoadBtn.setFont(new Font("Tahoma", Font.PLAIN, 9));
		gpr1LoadBtn.setBounds(300, 70, 18, 14);
		gpr1LoadBtn.setMargin(new Insets(0, 0, 0, -3));

		gpr2LoadBtn = new JButton("LD");
		gpr2LoadBtn.setFont(new Font("Tahoma", Font.PLAIN, 9));
		gpr2LoadBtn.setBounds(300, 100, 18, 14);
		gpr2LoadBtn.setMargin(new Insets(0, 0, 0, -3));

		gpr3LoadBtn = new JButton("LD");
		gpr3LoadBtn.setFont(new Font("Tahoma", Font.PLAIN, 9));
		gpr3LoadBtn.setBounds(300, 130, 18, 14);
		gpr3LoadBtn.setMargin(new Insets(0, 0, 0, -3));

		ixr1LoadBtn = new JButton("LD");
		ixr1LoadBtn.setFont(new Font("Tahoma", Font.PLAIN, 9));
		ixr1LoadBtn.setBounds(300, 165, 18, 14);
		ixr1LoadBtn.setMargin(new Insets(0, 0, 0, -3));

		ixr2LoadBtn = new JButton("LD");
		ixr2LoadBtn.setFont(new Font("Tahoma", Font.PLAIN, 9));
		ixr2LoadBtn.setBounds(300, 195, 18, 14);
		ixr2LoadBtn.setMargin(new Insets(0, 0, 0, -3));

		ixr3LoadBtn = new JButton("LD");
		ixr3LoadBtn.setFont(new Font("Tahoma", Font.PLAIN, 9));
		ixr3LoadBtn.setBounds(300, 225, 18, 14);
		ixr3LoadBtn.setMargin(new Insets(0, 0, 0, -3));

		runBtn = new JButton("Run");
		runBtn.setBounds(630, 307, 70, 25);

		loadBtn = new JButton("IPL");
		loadBtn.setBounds(630, 263, 70, 25);

		pcLoadBtn = new JButton("LD");
		pcLoadBtn.setFont(new Font("Tahoma", Font.PLAIN, 9));
		pcLoadBtn.setMargin(new Insets(0, 0, 0, -3));
		pcLoadBtn.setBounds(765, 40, 18, 14);

		marLoadBtn = new JButton("LD");
		marLoadBtn.setMargin(new Insets(0, 0, 0, -3));
		marLoadBtn.setFont(new Font("Tahoma", Font.PLAIN, 9));
		marLoadBtn.setBounds(765, 70, 18, 14);

		irLoadBtn = new JButton("LD");
		irLoadBtn.setMargin(new Insets(0, 0, 0, -3));
		irLoadBtn.setFont(new Font("Tahoma", Font.PLAIN, 9));
		irLoadBtn.setBounds(765, 100, 18, 14);

		// error dialog box
		errorDialogBox = new JDialog();

		// Add To Frame Here

		frame.getContentPane().add(gpr0Lbl);
		frame.getContentPane().add(gpr0ValueLbl);

		frame.getContentPane().add(gpr1Lbl);
		frame.getContentPane().add(gpr1ValueLbl);

		frame.getContentPane().add(gpr2Lbl);
		frame.getContentPane().add(gpr2ValueLbl);

		frame.getContentPane().add(gpr3Lbl);
		frame.getContentPane().add(gpr3ValueLbl);

		frame.getContentPane().add(loadBtn);
		frame.getContentPane().add(runBtn);

		frame.getContentPane().add(oprInput);
		frame.getContentPane().add(gprInput);
		frame.getContentPane().add(ixrInput);
		frame.getContentPane().add(indexInput);
		frame.getContentPane().add(addrInput);

		frame.getContentPane().add(oprInputLbl);
		frame.getContentPane().add(gprInputLbl);
		frame.getContentPane().add(ixrInputLbl);
		frame.getContentPane().add(indexInputLbl);
		frame.getContentPane().add(addrInputLbl);

		frame.getContentPane().add(ixr1Lbl);
		frame.getContentPane().add(ixr1ValueLbl);

		frame.getContentPane().add(ixr2Lbl);
		frame.getContentPane().add(ixr2ValueLbl);

		frame.getContentPane().add(ixr3Lbl);
		frame.getContentPane().add(ixr3ValueLbl);

		frame.getContentPane().add(gpr0LoadBtn);
		frame.getContentPane().add(gpr1LoadBtn);
		frame.getContentPane().add(gpr2LoadBtn);
		frame.getContentPane().add(gpr3LoadBtn);
		frame.getContentPane().add(ixr1LoadBtn);
		frame.getContentPane().add(ixr2LoadBtn);
		frame.getContentPane().add(ixr3LoadBtn);

		frame.getContentPane().add(pcLbl);
		frame.getContentPane().add(marLbl);
		frame.getContentPane().add(mbrLbl);
		frame.getContentPane().add(irLbl);
		frame.getContentPane().add(mfrLbl);
		frame.getContentPane().add(prvlgLbl);

		frame.getContentPane().add(pcValueLbl);
		frame.getContentPane().add(marValueLbl);
		frame.getContentPane().add(mbrValueLbl);
		frame.getContentPane().add(irValueLbl);
		frame.getContentPane().add(mfrValueLbl);
		frame.getContentPane().add(prvlgValueLbl);

		frame.getContentPane().add(pcLoadBtn);
		frame.getContentPane().add(marLoadBtn);
		frame.getContentPane().add(irLoadBtn);

		frame.setVisible(true);

	}

	private static void SetMapValues() {
		gprInputMux.put("00", "gpr0ValueLbl");
		gprInputMux.put("01", "gpr1ValueLbl");
		gprInputMux.put("10", "gpr2ValueLbl");
		gprInputMux.put("11", "gpr3ValueLbl");
	}

	private static void SetDefaultValues() {
		gpr0ValueLbl.setText(Constants.default16Zeroes);
		gpr1ValueLbl.setText(Constants.default16Zeroes);
		gpr2ValueLbl.setText(Constants.default16Zeroes);
		gpr3ValueLbl.setText(Constants.default16Zeroes);
		ixr1ValueLbl.setText(Constants.default16Zeroes);
		ixr2ValueLbl.setText(Constants.default16Zeroes);
		ixr3ValueLbl.setText(Constants.default16Zeroes);
		pcValueLbl.setText(Constants.default12Zeroes);
		marValueLbl.setText(Constants.default12Zeroes);
		mbrValueLbl.setText(Constants.default16Zeroes);
		irValueLbl.setText(Constants.default16Zeroes);
		mfrValueLbl.setText(Constants.default4Zeroes);
		prvlgValueLbl.setText(Constants.defaultSingleZero);
	}

	private static String LoadGPR() throws Exception
	{
				try {
//					if (!oprInput.getText().isEmpty() && !gprInput.getText().isEmpty() && !ixrInput.getText().isEmpty()
//							&& !indexInput.getText().isEmpty() && !addrInput.getText().isEmpty())
						return new UserInputReader(oprInput.getText(), gprInput.getText(), ixrInput.getText(),
							indexInput.getText(), addrInput.getText()).GetUserInput();
				} catch (Exception e) {
					throw new Exception(e.getMessage());
			}
	}

	private static void ShowError(String error) {
		JLabel errorMsg = new JLabel(error);
		//errorMsg.setHorizontalTextPosition(SwingConstants.CENTER);
		errorMsg.setHorizontalAlignment(SwingConstants.CENTER);
		errorDialogBox.setSize(800, 250);
		errorDialogBox.getContentPane().add(errorMsg);
		errorDialogBox.setLocationRelativeTo(null);
		errorDialogBox.setVisible(true);
	}
}
