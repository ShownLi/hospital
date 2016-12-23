<?xml version="1.0"?>
<?mso-application progid="Excel.Sheet"?>
<Workbook xmlns="urn:schemas-microsoft-com:office:spreadsheet"
 xmlns:o="urn:schemas-microsoft-com:office:office"
 xmlns:x="urn:schemas-microsoft-com:office:excel"
 xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet"
 xmlns:html="http://www.w3.org/TR/REC-html40">
 <DocumentProperties xmlns="urn:schemas-microsoft-com:office:office">
  <Created>2006-09-16T00:00:00Z</Created>
  <LastSaved>2006-09-16T00:00:00Z</LastSaved>
  <Version>15.00</Version>
 </DocumentProperties>
 <OfficeDocumentSettings xmlns="urn:schemas-microsoft-com:office:office">
  <AllowPNG/>
  <RemovePersonalInformation/>
 </OfficeDocumentSettings>
 <ExcelWorkbook xmlns="urn:schemas-microsoft-com:office:excel">
  <WindowHeight>8010</WindowHeight>
  <WindowWidth>14805</WindowWidth>
  <WindowTopX>240</WindowTopX>
  <WindowTopY>105</WindowTopY>
  <ProtectStructure>False</ProtectStructure>
  <ProtectWindows>False</ProtectWindows>
 </ExcelWorkbook>
 <Styles>
  <Style ss:ID="Default" ss:Name="Normal">
   <Alignment ss:Vertical="Bottom"/>
   <Borders/>
   <Font ss:FontName="宋体" x:CharSet="134" ss:Size="11" ss:Color="#000000"/>
   <Interior/>
   <NumberFormat/>
   <Protection/>
  </Style>
  <Style ss:ID="s64">
   <Borders>
    <Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1"/>
    <Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1"/>
   </Borders>
  </Style>
 </Styles>
 <Worksheet ss:Name="Sheet1">
  <Table ss:ExpandedColumnCount="12" ss:ExpandedRowCount="2" x:FullColumns="1"
   x:FullRows="1" ss:DefaultColumnWidth="54" ss:DefaultRowHeight="13.5">
   <Row>
    <Cell ss:StyleID="s64"><Data ss:Type="String">跟单员</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">询单数量</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">待处理</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">沟通中</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">地接设计中</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">成行</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">未成行</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">无效</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">付款</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">成交金额</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">收款金额</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">成交率</Data></Cell>
   </Row>
   <#list tempList as temp> 
   <Row>
    <Cell ss:StyleID="s64"><Data ss:Type="String">${temp.userName}</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">${temp.total}</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">${temp.pendingNum}</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">${temp.communicatingNum}</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">${temp.agencyDesigningNum}</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">${temp.dealNum}</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">${temp.noDealNum}</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">${temp.invalidNum}</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">${temp.paidNum}</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">${temp.totalDealMoney}</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">${temp.totalPaidMoney}</Data></Cell>
    <Cell ss:StyleID="s64"><Data ss:Type="String">${temp.dealPercent}</Data></Cell>
   </Row>
   </#list> 
  </Table>
  <WorksheetOptions xmlns="urn:schemas-microsoft-com:office:excel">
   <PageSetup>
    <Header x:Margin="0.3"/>
    <Footer x:Margin="0.3"/>
    <PageMargins x:Bottom="0.75" x:Left="0.7" x:Right="0.7" x:Top="0.75"/>
   </PageSetup>
   <Print>
    <ValidPrinterInfo/>
    <PaperSizeIndex>9</PaperSizeIndex>
    <HorizontalResolution>600</HorizontalResolution>
    <VerticalResolution>600</VerticalResolution>
   </Print>
   <Selected/>
   <Panes>
    <Pane>
     <Number>3</Number>
     <ActiveRow>9</ActiveRow>
     <ActiveCol>1</ActiveCol>
    </Pane>
   </Panes>
   <ProtectObjects>False</ProtectObjects>
   <ProtectScenarios>False</ProtectScenarios>
  </WorksheetOptions>
 </Worksheet>
</Workbook>
